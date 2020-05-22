public static boolean match(double[] array1, double[] array2) {
    boolean b = false;
    int index = 0;
    int count = 0;
    for (int i = 0; i < array1.length; i++) {
        if (array1[i] > array2[index++] && array1[i] < array2[index++]) {
            count++;  
        }
    }
    if (count == array1.length) {
        b = true; 
    }
    return b;
}