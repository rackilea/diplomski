public static void main(String args[]) {
    double[] testValues = new double[100];
    for (int i = 0; i < 100; i++) {
        testValues[i] = Math.random() * 11.0;
    }
    drawHistogram(testValues);
}