private static void min() {
    minArray = new double[largeArray.length]; // <-- initialize the array
    for (int row = 0; row < largeArray.length; row++) {
        min = largeArray[row][0];
        for (int col = 1; col < largeArray[row].length; col++) {
            min = Math.min(min, largeArray[row][col]);
        }
        minArray[row] = min;
    }
    System.out.println(Arrays.toString(minArray));
}