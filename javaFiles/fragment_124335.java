public <T> T[] addToNewArrayAndPrint(T item) {
    Object[] array = new Object[1];
    array[0] = item;
    System.out.println((T) array[0]);
    return array;
}