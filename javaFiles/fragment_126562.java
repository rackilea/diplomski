static int countOccurrences(double[] list, double targetValue) {
    int count = 0;
    for (int i = 0; i < list.length; i++) {
        if (list[i] == targetValue)
            count++;
    }
}


static double getMostFrequentValue(double[] list) {
    int mostFrequentCount = 0;
    double mostFrequentValue = 0;
    for (int i = 0; i < list.length; i++) {
        double value = list[i];
        int count = countOccurrences(list, value);
        if (count > mostFrequentCount) {
            mostFrequentCount = count;
            mostFrequentValue = value;
        }
    }
    return mostFrequentValue;
}