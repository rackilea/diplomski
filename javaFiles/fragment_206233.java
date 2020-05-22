final class Coordinates {

    @SerializedName("lat")
    final double latitude;

    @SerializedName("lon")
    final double longitude;

    private Coordinates(final double latitude, final double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    static Coordinates of(final double latitude, final double longitude) {
        return new Coordinates(latitude, longitude);
    }

    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        final Coordinates that = (Coordinates) o;
        return Double.compare(that.latitude, latitude) == 0
                && Double.compare(that.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        final long latitudeBits = Double.doubleToLongBits(latitude);
        final long longitudeBits = Double.doubleToLongBits(longitude);
        final int latitudeHash = (int) (latitudeBits ^ latitudeBits >>> 32);
        final int longitudeHash = (int) (longitudeBits ^ longitudeBits >>> 32);
        return 31 * latitudeHash + longitudeHash;
    }

}