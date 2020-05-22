private static Counter[] createCounters(int counterNums,
                                        int digits,
                                        int[] countervals) {
    if (digits < 1) {
        // TODO: Throw an exception instead?
        System.out.println("Invalid number of digits, reverting to 1 digit");
        digits = 1;
    }
    Counter[] counter = new int[counterNums];
    for (int i=0; i < counterNums; i++) {

        counter[i] = new Counter(digits, counterBals[i]);
    }
    return counter;
}