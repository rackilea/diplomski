public <T> T[] addToNewArrayAndPrint(T item) {
    T[] array = new T[10];
    array[0] = item;
    System.out.println(array[0]);
    return array;
}