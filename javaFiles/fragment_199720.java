public static void main(String[] args) {
    int n = 3;

    int[] result = new int[n*(n+1)/2];
    int index = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= i; j++) {
            result[index++] = j + 1;
        }
    }

    System.out.println(Arrays.toString(result));
}