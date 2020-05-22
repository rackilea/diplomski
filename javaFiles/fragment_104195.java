public static int closest(double[] array, double n) {
    double leastDifference = Double.POSITIVE_INFINITY;
    int indexOfLeastDifference = -1;
    for (int a = 0; a < array.length; a++) {
        double difference = Math.abs(array[a] - n);
        if (difference < leastDifference) {
            indexOfLeastDifference = a;
            leastDifference = difference;
        }
    }
    return indexOfLeastDifference;
}