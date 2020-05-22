public void searchArray(int[] randomNumbers, int numSearch) {
    int count = 0;

    for (int i : randomNumbers) {
        if (i == numSearch) {
            count++;
        }
    }
    if (count == 0) {
        System.out.println("Single #" + numSearch + " was not found!");
    } else {
        System.out.println("Single # "+ numSearch + " was found " + count + " times");
    }
}