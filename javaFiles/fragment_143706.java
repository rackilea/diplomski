private static void printFrequency() {
    int[] countArray = new int[10];
    for(int x : array) {
        countArray[x]++;
    }

    System.out.print("Frequencies: ");
    for(int i = 0; i < 10; i++) {
        System.out.print("There are " + countArray[i] + ", " + i + "'s ");
    }
}