public static int sum(int lowerbound, int upperbound, IntFunction<Integer> function) {
    int partialsum = 0;
    for (int i = lowerbound; i <= upperbound; i++) {
        partialsum = partialsum + function.apply(i);
    }
    return partialsum;
}