private Pair<Double, Double> getPositionOf(Pair<Double, Double> lastPosition, double angle, int distance, int angleAdjustment)
    {
        final Pair<Double, Double> rotatedLeftPosition = rotateLeft(lastPosition, 360 - angleAdjustment);
        final Pair<Double, Double> translatedLocation = applyTranslationTo(rotatedLeftPosition, angle, distance);
        return rotateLeft(translatedLocation, angleAdjustment);
    }

    private Pair<Double, Double> rotateLeft(Pair<Double, Double> position, double degreeAngle)
    {
        double x = position.first;
        double y = position.second;

        double adjustedX = (x * Math.cos(degreeAngle)) - (y * Math.sin(degreeAngle));
        double adjustedY = (y * Math.cos(degreeAngle)) + (x * Math.sin(degreeAngle));
        return new Pair<>(adjustedX, adjustedY);
    }

    @NotNull
    private Pair<Double, Double> applyTranslationTo(final Pair<Double, Double> position, final double angle, final int distance)
    {
        double x = distance * Math.cos(angle);
        double y = distance * Math.sin(angle);
        return new Pair<>(position.first + x, position.second + y);
    }