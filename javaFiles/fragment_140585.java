public static int myMethod(int[] array) {
    int statements = 0;
    for (int next = 1; next < array.length; next++) {
        statements+=3;
        int val = array[next];
        int index = next;
        while (index > 0 && val < array[index - 1]) {
            statements+=2;
            array[index] = array[index - 1];
            index--;
        }
        array[index] = val;
    }
    return statements;
}