private static void mySort(int[] myArray) {
    for (int i = 0; i < myArray.length; i++) { // Removed -1
        for (int j = 1; j < myArray.length - i; j++) { // Removed -1, corrected from i++ to j++
            if (myArray[j] < myArray[j - 1]) {
                int temp = myArray[j - 1];
                myArray[j - 1] = myArray[j];
                myArray[j] = temp;
            }
        }
    }
}