class CoordinatesContainer {

    private double[][][] coordinates;

    public double[][][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[][][] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(1024);
        for (double[] arrayItem : coordinates[0]) {
            builder.append(Arrays.toString(arrayItem));
            builder.append(", ");
        }
        return builder.toString();
    }
}