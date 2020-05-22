public static <T> List<T> limitArray(T[] array, int limit) {
    if (limit > array.length) {
        return Arrays.asList(array);
    }
    List<T> list = new ArrayList<T>();
    double stepSize = ((double) array.length - 1) / ((double) limit - 1);
    double i = 0;
    while (i < array.length) {
        list.add(array[(int) i]);
        i += stepSize;
    }
    return list;
}