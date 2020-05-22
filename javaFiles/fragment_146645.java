public static int[] toIntArray(List<Integer> list) {
    return toPrimitiveArray(list, int[].class);
}
public static double[] toDoubleArray(List<Double> list) {
    return toPrimitiveArray(list, double[].class);
}
...