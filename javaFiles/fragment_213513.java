public static void shuffle (int[] array) {
    for(int n = array.length; (n > 1);) {
        int k = gen.nextInt(n--);
        int temp = array[n];
        array[n] = array[k];
        array[k] = temp;
    }
}