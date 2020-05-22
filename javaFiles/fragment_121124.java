void showConsecutiveCharacterCounts(char[] input) {
    int consecutiveCount = 0;
    /* iterate through all chars */
    for (int i = 0; i < input.length; i++) {
        /* increment count - will be 1 first time */
        consecutiveCount++;
        /* if we are at the end of a sequence of chars
           I.e. end of input OR next char does not match */
        if (i == input.length - 1 || input[i] != input[i + 1]) {
            /* print previous sequence */
            System.out.println(input[i] + " appears " + consecutiveCount + " times");
            /* and reset count */
            consecutiveCount = 0;
        }
    }
}