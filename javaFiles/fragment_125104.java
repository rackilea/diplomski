public static void findMax(Function f, double lowerBound, double upperBound, double step) {
    double maxValue = f.f(lowerBound);

    for (double i=lowerBound; i <= upperBound; i+=step) {
        double currEval = f.f(i);
        if (currEval > maxValue) {
            maxValue = currEval;
        }
    }

    return maxValue;
}