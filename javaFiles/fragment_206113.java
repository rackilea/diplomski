public static <T> void remove1stArrayElementFromEveryElement(List<T[]> list) {
    for (ListIterator<T[]> iter = list.listIterator(); iter.hasNext(); ) {
        T[] array = iter.next();
        array = Arrays.copyOfRange(array, 1, array.length);
        iter.set(array);
    }
}