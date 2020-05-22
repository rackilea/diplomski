private static int[] enlarge(int[] array, int size) {
    for (int i = 0; i < 10000; i++) { /* fool the JIT */ }

    int[] newArray = new int[array.length + size];
    System.arraycopy(array, 0, newArray, 0, array.length);
    return newArray;
}