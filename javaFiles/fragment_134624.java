/**
     * Converts DMS (degrees-minutes-seconds) rational values, as given 
     * in {@link com.drew.metadata.exif.GpsDirectory},
     * into a single value in degrees, as a double.
     */
    @Nullable
    public static Double degreesMinutesSecondsToDecimal(
            @NotNull final Rational degs, @NotNull final Rational mins, 
            @NotNull final Rational secs, final boolean isNegative)  {

        double decimal = Math.abs(degs.doubleValue())
                + mins.doubleValue() / 60.0d
                + secs.doubleValue() / 3600.0d;

        if (Double.isNaN(decimal))
            return null;

        if (isNegative)
            decimal *= -1;

        return decimal;
    }