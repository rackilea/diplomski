import java.util.ArrayList;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 * Based on javafx.animation.PathTransition
 * 
 * @author jpereda
 */
public class PathInterpolator {

    private final Path originalPath;
    private final Node node;

    private double totalLength = 0;
    private static final int SMOOTH_ZONE = 10;
    private final ArrayList<Segment> segments = new ArrayList<>();
    private Segment moveToSeg = Segment.getZeroSegment();
    private Segment lastSeg = Segment.getZeroSegment();

    public PathInterpolator(Path path, Node node){
        this.originalPath=path;
        this.node=node;
        calculateSegments();
    }

    public PathInterpolator(Shape shape, Node node){
        this.originalPath=(Path)Shape.subtract(shape, new Rectangle(0,0));
        this.node=node;
        calculateSegments();
    }


    private void calculateSegments() {
        segments.clear();
        Path linePath = new LinearPath(originalPath).generateLinePath();
        linePath.getElements().forEach(elem->{
            Segment newSeg = null;
            if(elem instanceof MoveTo){
                moveToSeg = Segment.newMoveTo(((MoveTo)elem).getX(),((MoveTo)elem).getY(), lastSeg.accumLength);
                newSeg = moveToSeg;
            } else if(elem instanceof LineTo){
                newSeg = Segment.newLineTo(lastSeg, ((LineTo)elem).getX(),((LineTo)elem).getY());
            } else if(elem instanceof ClosePath){
                newSeg = Segment.newClosePath(lastSeg, moveToSeg);
                if (newSeg == null) {
                    lastSeg.convertToClosePath(moveToSeg);
                }
            }
            if (newSeg != null) {
                segments.add(newSeg);
                lastSeg = newSeg;
            }
        });
        totalLength = lastSeg.accumLength;
    }

    public void interpolate(double frac) {
        interpolate(frac,0,0);
    }

    public void interpolate(double frac, double translateX, double translateY) {
        double part = totalLength * Math.min(1, Math.max(0, frac));
        int segIdx = findSegment(0, segments.size() - 1, part);
        Segment seg = segments.get(segIdx);

        double lengthBefore = seg.accumLength - seg.length;

        double partLength = part - lengthBefore;

        double ratio = partLength / seg.length;
        Segment prevSeg = seg.prevSeg;
        double x = prevSeg.toX + (seg.toX - prevSeg.toX) * ratio;
        double y = prevSeg.toY + (seg.toY - prevSeg.toY) * ratio;
        double rotateAngle = seg.rotateAngle;

        // provide smooth rotation on segment bounds
        double z = Math.min(SMOOTH_ZONE, seg.length / 2);
        if (partLength < z && !prevSeg.isMoveTo) {
            //interpolate rotation to previous segment
            rotateAngle = interpolateAngle(
                    prevSeg.rotateAngle, seg.rotateAngle,
                    partLength / z / 2 + 0.5F);
        } else {
            double dist = seg.length - partLength;
            Segment nextSeg = seg.nextSeg;
            if (dist < z && nextSeg != null) {
                //interpolate rotation to next segment
                if (!nextSeg.isMoveTo) {
                    rotateAngle = interpolateAngle(
                            seg.rotateAngle, nextSeg.rotateAngle,
                            (z - dist) / z / 2);
                }
            }
        }
        node.setTranslateX(x - getPivotX() + translateX);
        node.setTranslateY(y - getPivotY() + translateY);
        node.setRotate(rotateAngle);       
    }

    private double getPivotX() {
        final Bounds bounds = node.getLayoutBounds();
        return bounds.getMinX() + bounds.getWidth()/2;
    }

    private double getPivotY() {
        final Bounds bounds = node.getLayoutBounds();
        return bounds.getMinY() + bounds.getHeight()/2;
    }

    /**
     * Returns the index of the first segment having accumulated length
     * from the path beginning, greater than {@code length}
     */
    private int findSegment(int begin, int end, double length) {
        // check for search termination
        if (begin == end) {
            // find last non-moveTo segment for given length
            return segments.get(begin).isMoveTo && begin > 0
                    ? findSegment(begin - 1, begin - 1, length)
                    : begin;
        }
        // otherwise continue binary search
        int middle = begin + (end - begin) / 2;
        return segments.get(middle).accumLength > length
                ? findSegment(begin, middle, length)
                : findSegment(middle + 1, end, length);
    }
    /** Interpolates angle according to rate,
     *  with correct 0->360 and 360->0 transitions
     */
    private static double interpolateAngle(double fromAngle, double toAngle, double ratio) {
        double delta = toAngle - fromAngle;
        if (Math.abs(delta) > 180) {
            toAngle += delta > 0 ? -360 : 360;
        }
        return normalize(fromAngle + ratio * (toAngle - fromAngle));
    }

    /** Converts angle to range 0-360
     */
    private static double normalize(double angle) {
        while (angle > 360) {
            angle -= 360;
        }
        while (angle < 0) {
            angle += 360;
        }
        return angle;
    }

    private static class Segment {

        private static final Segment zeroSegment = new Segment(true, 0, 0, 0, 0, 0);
        boolean isMoveTo;
        double length;
        // total length from the path's beginning to the end of this segment
        double accumLength;
        // end point of this segment
        double toX;
        double toY;
        // segment's rotation angle in degrees
        double rotateAngle;
        Segment prevSeg;
        Segment nextSeg;

        private Segment(boolean isMoveTo, double toX, double toY,
                double length, double lengthBefore, double rotateAngle) {
            this.isMoveTo = isMoveTo;
            this.toX = toX;
            this.toY = toY;
            this.length = length;
            this.accumLength = lengthBefore + length;
            this.rotateAngle = rotateAngle;
        }

        public static Segment getZeroSegment() {
            return zeroSegment;
        }

        public static Segment newMoveTo(double toX, double toY,
                double accumLength) {
            return new Segment(true, toX, toY, 0, accumLength, 0);
        }

        public static Segment newLineTo(Segment fromSeg, double toX, double toY) {
            double deltaX = toX - fromSeg.toX;
            double deltaY = toY - fromSeg.toY;
            double length = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
            if ((length >= 1) || fromSeg.isMoveTo) { // filtering out flattening noise
                double sign = Math.signum(deltaY == 0 ? deltaX : deltaY);
                double angle = (sign * Math.acos(deltaX / length));
                angle = normalize(angle / Math.PI * 180);
                Segment newSeg = new Segment(false, toX, toY,
                        length, fromSeg.accumLength, angle);
                fromSeg.nextSeg = newSeg;
                newSeg.prevSeg = fromSeg;
                return newSeg;
            }
            return null;
        }

        public static Segment newClosePath(Segment fromSeg, Segment moveToSeg) {
            Segment newSeg = newLineTo(fromSeg, moveToSeg.toX, moveToSeg.toY);
            if (newSeg != null) {
                newSeg.convertToClosePath(moveToSeg);
            }
            return newSeg;
        }

        public void convertToClosePath(Segment moveToSeg) {
            Segment firstLineToSeg = moveToSeg.nextSeg;
            nextSeg = firstLineToSeg;
            firstLineToSeg.prevSeg = this;
        }

    }

}