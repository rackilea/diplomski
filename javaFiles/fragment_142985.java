public int getMinimalValue(int firstArg, int... remainingArgs) {
        int minimum = firstArg;
        for (int arg : remainingArgs) {
            if (arg < minimum) {
                minimum = arg;
            }
        }
        return minimum;
    }