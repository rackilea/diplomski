public static int[] shuffle(int[] array, int N) {
    int[] result = new int[N];
    int length = array.length;

    Random gen = new Random();

    for (int i = 0; i < N; i++) {
        int r = gen.nextInt(length);

        result[i] = array[r];

        array[r] = array[length-1];
        length--;
    }

    return result;
}