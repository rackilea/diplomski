private static int getChainLength(long number, int chainlength) {
        // All chains should end with 1.
        while (number != 1) {
            // If the number is even, halve the number, otherwise multiply it by 3 and add 1.
            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = number * 3 + 1;
            }
            // Call this function again.
            ++chainlength;
        }
        // Return the length of the chain.
        return chainlength;
    }