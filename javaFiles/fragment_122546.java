static <T> void rotate4(List<T> list, int i0, int i1, int i2, int i3) {
    T item = list.get(i3);
    item = list.set(i0, item);
    item = list.set(i1, item);
    item = list.set(i2, item);
    item = list.set(i3, item);
}