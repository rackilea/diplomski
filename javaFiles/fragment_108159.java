static class FixZoomPositionAnimator extends BasicAnimator
{
    static final String VIEW_ANIM_KEY = "FixZoomPositionAnimator";
    static final double EPS = 0.005;

    private final java.awt.Point mouseControlPoint;
    private final Position mouseGeoLocation;
    private final Vec4 mouseGeoPoint;
    private final BasicOrbitView orbitView;
    private final Animator zoomAnimator;

    private int lastDxSign = 0;
    private int lastDySign = 0;
    int stepNumber = 0;
    int stepsNoAdjustments = 0;


    FixZoomPositionAnimator(BasicOrbitView orbitView, Animator zoomAnimator, java.awt.Point mouseControlPoint, Position mouseGeoLocation)
    {
        this.orbitView = orbitView;
        this.zoomAnimator = zoomAnimator;
        this.mouseControlPoint = mouseControlPoint;
        this.mouseGeoLocation = mouseGeoLocation;
        mouseGeoPoint = orbitView.getGlobe().computePointFromLocation(mouseGeoLocation);
    }

    public Point getMouseControlPoint()
    {
        return mouseControlPoint;
    }

    public Position getMouseGeoLocation()
    {
        return mouseGeoLocation;
    }

    private static int sign(double d)
    {
        if (Math.abs(d) < EPS)
            return 0;
        else if (d > 0)
            return 1;
        else
            return -1;
    }

    double calcAccelerationK(double dSign, double lastDSign)
    {
        // as we are following zoom trying to catch up - accelerate adjustment
        // but slow down if we overshot the target last time
        if (!zoomAnimator.hasNext())
            return 1.0;
        else if (dSign != lastDSign)
            return 0.5;
        else
        {
            // reduce acceleration over time
            if (stepNumber < 10)
                return 5;
            else if (stepNumber < 20)
                return 3;
            else
                return 2;
        }
    }

    static boolean isBetween(double checkedValue, double target1, double target2)
    {
        return ((target1 < checkedValue) && (checkedValue < target2))
            || ((target1 > checkedValue) && (checkedValue > target2));
    }

    static boolean isValid(Position position)
    {
        return isBetween(position.longitude.degrees, -180, 180)
            && isBetween(position.latitude.degrees, -90, 90);
    }

    @Override
    public void next()
    {
        // super.next();   // do not call super to avoid NullPointerException!

        nextWithTilt(); // works OK on tilted Earth
        // nextOld();   // IMHO better looking but stops working is user tilts the Earth

    }

    private void nextOld()
    {
        stepNumber++;

        Vec4 curProjection = orbitView.project(mouseGeoPoint);
        Rectangle viewport = orbitView.getViewport();

        // for Y sign is inverted
        double dX = (mouseControlPoint.x - curProjection.x);
        double dY = (mouseControlPoint.y + curProjection.y - viewport.getHeight());

        if (Math.abs(dX) > EPS || Math.abs(dY) > EPS)
        {

            double dCX = (mouseControlPoint.x - viewport.getCenterX());
            double dCY = (mouseControlPoint.y + viewport.getCenterY() - viewport.getHeight());

            final double stepPx = 10;

            // As the Earth is curved and we are not guaranteed to have a frontal view on it
            // latitude an longitude lines are not really parallel to X or Y. But we assume that
            // locally they are parallel enough both around the mousePoint and around the center.
            // So we use reference points near center to calculate how we want to move the center.
            Vec4 controlPointRight = new Vec4(viewport.getCenterX() + stepPx, viewport.getCenterY());
            Vec4 geoPointRight = orbitView.unProject(controlPointRight);
            Position positionRight = (geoPointRight != null) ? orbitView.getGlobe().computePositionFromPoint(geoPointRight) : null;
            Vec4 controlPointUp = new Vec4(viewport.getCenterX(), viewport.getCenterY() - stepPx);
            Vec4 geoPointUp = orbitView.unProject(controlPointUp);
            Position positionUp = (geoPointUp != null) ? orbitView.getGlobe().computePositionFromPoint(geoPointUp) : null;

            Position centerPosition = orbitView.getCenterPosition();

            double newCenterLongDeg;
            if (Math.abs(dCX) <= 1.0) // same X => same longitude
            {
                newCenterLongDeg = mouseGeoLocation.longitude.degrees;
            }
            else if (positionRight == null)  // if controlPointRight is outside of the globe - don't try to fix this coordinate
            {
                newCenterLongDeg = centerPosition.longitude.degrees;
            }
            else
            {
                double scaleX = -dX / stepPx;
                // apply acceleration if possible
                int dXSign = sign(dX);
                double accScaleX = scaleX * calcAccelerationK(dXSign, lastDxSign);
                lastDxSign = dXSign;
                newCenterLongDeg = centerPosition.longitude.degrees * (1 - accScaleX) + positionRight.longitude.degrees * accScaleX;
                // if we overshot - use non-accelerated mode
                if (!isBetween(newCenterLongDeg, centerPosition.longitude.degrees, mouseGeoLocation.longitude.degrees)
                    || !isBetween(newCenterLongDeg, -180, 180))
                {
                    newCenterLongDeg = centerPosition.longitude.degrees * (1 - scaleX) + positionRight.longitude.degrees * scaleX;
                }
            }

            double newCenterLatDeg;
            if (Math.abs(dCY) <= 1.0) // same Y => same latitude
            {
                newCenterLatDeg = mouseGeoLocation.latitude.degrees;
            }
            else if (positionUp == null)  // if controlPointUp is outside of the globe - don't try to fix this coordinate
            {
                newCenterLatDeg = centerPosition.latitude.degrees;
            }
            else
            {
                double scaleY = -dY / stepPx;

                // apply acceleration if possible
                int dYSign = sign(dY);
                double accScaleY = scaleY * calcAccelerationK(dYSign, lastDySign);
                lastDySign = dYSign;
                newCenterLatDeg = centerPosition.latitude.degrees * (1 - accScaleY) + positionUp.latitude.degrees * accScaleY;
                // if we overshot - use non-accelerated mode
                if (!isBetween(newCenterLatDeg, centerPosition.latitude.degrees, mouseGeoLocation.latitude.degrees)
                    || !isBetween(newCenterLatDeg, -90, 90))
                {
                    newCenterLatDeg = centerPosition.latitude.degrees * (1 - scaleY) + positionUp.latitude.degrees * scaleY;
                }
            }
            Position newCenterPosition = Position.fromDegrees(newCenterLatDeg, newCenterLongDeg);
            orbitView.setCenterPosition(newCenterPosition);
        }

        if (!zoomAnimator.hasNext())
            stop();
    }

    private void nextWithTilt()
    {
        stepNumber++;

        if (!zoomAnimator.hasNext() || (stepsNoAdjustments > 20))
        {
            System.out.println("Stop after " + stepNumber);
            stop();
        }

        Vec4 curProjection = orbitView.project(mouseGeoPoint);
        Rectangle viewport = orbitView.getViewport();
        System.out.println("----------------------------------");
        System.out.println("Mouse: mouseControlPoint = " + mouseControlPoint + "\t location = " + mouseGeoLocation + "\t viewSize = " + viewport);
        System.out.println("Mouse: curProjection = " + curProjection);

        double dX = (mouseControlPoint.x - curProjection.x);
        double dY = (viewport.getHeight() - mouseControlPoint.y - curProjection.y);  // Y is inverted
        Vec4 dTgt = new Vec4(dX, dY);

        // sometimes if you zoom close to the edge curProjection is calculated as somewhere
        // way beyond where it is and it leads to overflow. This is a protection against it
        if (Math.abs(dX) > viewport.width / 4 || Math.abs(dY) > viewport.height / 4)
        {
            Vec4 unproject = orbitView.unProject(new Vec4(mouseControlPoint.x, viewport.getHeight() - mouseControlPoint.y));
            System.out.println("!!!End Mouse:"
                + " dX = " + dX + "\t" + " dY = " + dY
                + "\n" + "unprojectPt = " + unproject
                + "\n" + "unprojectPos = " + orbitView.getGlobe().computePositionFromPoint(unproject)
            );

            stepsNoAdjustments += 1;
            return;
        }

        if (Math.abs(dX) <= EPS && Math.abs(dY) <= EPS)
        {
            stepsNoAdjustments += 1;
            System.out.println("Mouse: No adjustment: " + " dX = " + dX + "\t" + " dY = " + dY);
            return;
        }
        else
        {
            stepsNoAdjustments = 0;
        }

        // create reference points about 10px away from the center to the Up and to the Right
        // and then map them to screen coordinates and geo coordinates
        // Unfortunately unproject often generates points far from the Earth surface (and
        // thus with significantly less difference in lat/long)
        // So this longer but more fool-proof calculation is used
        final double stepPx = 10;
        Position centerPosition = orbitView.getCenterPosition();
        Position eyePosition = orbitView.getEyePosition();
        double pixelGeoSize = orbitView.computePixelSizeAtDistance(eyePosition.elevation - centerPosition.elevation);
        Vec4 geoCenterPoint = orbitView.getCenterPoint();
        Vec4 geoRightPoint = geoCenterPoint.add3(new Vec4(pixelGeoSize * stepPx, 0, 0));
        Vec4 geoUpPoint = geoCenterPoint.add3(new Vec4(0, pixelGeoSize * stepPx, 0));

        Position geoRightPosition = orbitView.getGlobe().computePositionFromPoint(geoRightPoint);
        Position geoUpPosition = orbitView.getGlobe().computePositionFromPoint(geoUpPoint);

        Vec4 controlCenter = orbitView.project(geoCenterPoint);
        Vec4 controlRight = orbitView.project(geoRightPoint);
        Vec4 controlUp = orbitView.project(geoUpPoint);

        Vec4 controlRightDif = controlRight.subtract3(controlCenter);
        controlRightDif = new Vec4(controlRightDif.x, controlRightDif.y); // ignore z for scale calculation
        Vec4 controlUpDif = controlUp.subtract3(controlCenter);
        controlUpDif = new Vec4(controlUpDif.x, controlUpDif.y); // ignore z for scale calculation

        double scaleRight = -dTgt.dot3(controlRightDif) / controlRightDif.getLengthSquared3();
        double scaleUp = -dTgt.dot3(controlUpDif) / controlUpDif.getLengthSquared3();

        Position posRightDif = geoRightPosition.subtract(centerPosition);
        Position posUpDif = geoUpPosition.subtract(centerPosition);

        double totalLatDifDeg = posRightDif.latitude.degrees * scaleRight + posUpDif.latitude.degrees * scaleUp;
        double totalLongDifDeg = posRightDif.longitude.degrees * scaleRight + posUpDif.longitude.degrees * scaleUp;
        Position totalDif = Position.fromDegrees(totalLatDifDeg, totalLongDifDeg);

        // don't copy elevation!
        Position newCenterPosition = Position.fromDegrees(centerPosition.latitude.degrees + totalLatDifDeg,
            centerPosition.longitude.degrees + totalLongDifDeg);

        // if we overshot - try to slow down
        if (!isValid(newCenterPosition))
        {
            newCenterPosition = Position.fromDegrees(centerPosition.latitude.degrees + totalLatDifDeg / 2,
                centerPosition.longitude.degrees + totalLongDifDeg / 2);
            if (!isValid(newCenterPosition))
            {
                System.out.println("Too much overshot: " + newCenterPosition);
                stepsNoAdjustments += 1;
                return;
            }
        }

        System.out.println("Mouse:"
            + " dX = " + dX + "\t" + " dY = " + dY

            + "\n"
            + " centerPosition = " + centerPosition

            + "\n"
            + " geoUpPoint = " + geoUpPoint + "\t " + " geoUpPosition = " + geoUpPosition
            + "\n"
            + " geoRightPoint = " + geoRightPoint + "\t " + " geoRightPosition = " + geoRightPosition

            + "\n"
            + " posRightDif = " + posRightDif
            + "\t"
            + " posUpDif = " + posUpDif
            + "\n"
            + " scaleRight = " + scaleRight + "\t" + " scaleUp = " + scaleUp);
        System.out.println("Mouse: oldCenterPosition = " + centerPosition);
        System.out.println("Mouse: newCenterPosition = " + newCenterPosition);

        orbitView.setCenterPosition(newCenterPosition);
    }

}