private static void createCounters(int counterNums,
                                   int digits,
                                   int[] counterVals) {
    // Moved out of the loop, as it's pointless there.
    if (digits < 1) {
        // TODO: Throw an exception instead?
        System.out.println("Invalid number of digits, reverting to 1 digit");
        digits = 1;
    }
    counter = new Counter[counterNums];
    for (int i=0; i < counterNums; i++) {
        counter[i] = new Counter(digits, counterVals[i]);
    }    
}