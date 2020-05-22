public <T> List<T> limitArray(T[] array, int limit) {
    List<T> list = new ArrayList<T>();
    int i = 0;
    while (i < arrary.length && i < limit) {
        list.add(array[i]);
        i++;
    }
    return list;
}