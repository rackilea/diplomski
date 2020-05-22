for (int num : new int[] {500, 1000, 5000, ...}) {
    for (int i = 0; i < 4; i++) {
        String sort = null;
        int[] array = new int[num];
        randomlyFillArray(array, 1, 1000);
        long startTime = System.currentTimeMillis();
        if (i == 1) {
            sort = "SelectionSort";
            SelectionSort(array);
        } else if (i == ...) {
            // analogeous for other sorts
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(sort + " for " + num + " integers: " + elapsedTime);
    }
}