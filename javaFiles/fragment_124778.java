public static int thirdLargest(int[] array) {
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    int thirdLargest = Integer.MIN_VALUE;

    for (int number : array) {

        if (largest < number) {
            thirdLargest = secondLargest;
            secondLargest = largest;
            largest = number;
        } else if (secondLargest < number) {
            thirdLargest = secondLargest;
            secondLargest = number;
        } else if (thirdLargest < number) {
            thirdLargest = number;
        }
    }

    return thirdLargest;
}