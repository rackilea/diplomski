private static int monthsOfGrowthRequired(int startAmount,
        int targetAmount, double growthFactor) {
    int monthsOfGrowth = 0;
    int runningAmount = startAmount;
    while (runningAmount < targetAmount) {
        runningAmount *= growthFactor;
        ++monthsOfGrowth;
    }
    return monthsOfGrowth;
}