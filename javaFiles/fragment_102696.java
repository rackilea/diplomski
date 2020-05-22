public void test() {
    int[] array = {10, 20, 3, 5};

    int len = array.length;

    for (int j = 0; j < len - 1; j++) {
        int nge = -1;
        for (int i = j + 1; i < len && nge < 0; i++) {
            if (array[j] < array[i]) {
                nge = array[i];
            }
        }
        System.out.println(array[j] + "----> " + nge);
    }
    System.out.println(array[len-1] + "----> -1");
}