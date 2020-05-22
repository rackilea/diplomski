public static double[] convertToDouble(final float[] values) {
    final double[] result = new double[values.length];

    IntStream.range(0, values.length).forEach(index -> result[index] = values[index]);
    return result;
}