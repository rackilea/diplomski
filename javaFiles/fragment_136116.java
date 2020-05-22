public double[][] toArray() {
    return IntStream.range(0, Math.min(rowDimension, columnDimension)).mapToObj(r -> {
        double[] row = new double[columnDimension];
        row[r] = 1;
        return row;
    }).toArray(double[][]::new);
}