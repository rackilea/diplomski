public static void main(String[] args) {
    double[] arr1 = {.10, .15, .20, .30};
    double[] arr2 = {.25, .30, .28, .11};

    double sum = 0;
    int count = 0;
    while (count < arr1.length) {
        int j = count;
        for (int i = 0; i < arr1.length; i++, j++) {
            if (j > arr1.length - 1) {
                j = 0;
            }
            sum += arr1[i] * arr2[j];
        }
        count++;
    }
    System.out.println(sum);
}