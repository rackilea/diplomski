public void add(int number) {
    int[] anotherArray = new int[values.length + 1];
    System.arraycopy(values, 0, anotherArray, 0, values.length);
    anotherArray[values.length] = number;
    values = anotherArray;
}