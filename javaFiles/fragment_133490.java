private final static int MAX_CONSTANT = 16;
    private static BigInteger posConst[] = new BigInteger[MAX_CONSTANT+1];
    private static BigInteger negConst[] = new BigInteger[MAX_CONSTANT+1];
    static {
    for (int i = 1; i <= MAX_CONSTANT; i++) {
        int[] magnitude = new int[1];
        magnitude[0] = i;
        posConst[i] = new BigInteger(magnitude,  1);
        negConst[i] = new BigInteger(magnitude, -1);
    }
    }

    public static BigInteger valueOf(long val) {
        // If -MAX_CONSTANT < val < MAX_CONSTANT, return stashed constant
        if (val == 0)
            return ZERO;
        if (val > 0 && val <= MAX_CONSTANT)
            return posConst[(int) val];
        else if (val < 0 && val >= -MAX_CONSTANT)
            return negConst[(int) -val];
        return new BigInteger(val);
    }