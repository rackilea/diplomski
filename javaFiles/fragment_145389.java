public static void main(String[] args) {
    int[] array = new int[168]; // the 168th prime is 997
    int pos = 0;
    for (int j = 2; pos < array.length; j++) {
        if (isPrime(j)) {
            array[pos++] = j;
        }
    }
    System.out.println(Arrays.toString(array));
}