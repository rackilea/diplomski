private static double[] maximize(double[] test1, double[] test2) {
    double[] maxValues = new double[Math.max(test1.length, test2.length)];
    for (int i = 0; i < Math.min(test1.length, test2.length); i++) {
        maxValues[i] = Math.max(test1[i], test2[i]);
    }
    if (test1.length < test2.length) {
        for (int i = test1.length; i < test2.length; i++) {
            maxValues[i] = test2[i];
        }
    } else {
        for (int i = test2.length; i < test1.length; i++) {
            maxValues[i] = test1[i];
        }
    }
    return maxValues;
}