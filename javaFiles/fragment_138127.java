public static int fastExp(int b, int n) {
    //converts n (b^n) to binary for algorithm
    String nBinStr = Integer.toBinaryString(n);
    int nBinInt = Integer.parseInt(nBinStr);
    int length = String.valueOf(nBinInt).length();
    return exponentiator(b, length, nBinInt, b);
}

private static int exponentiator(int runningResult, int binLength, int binInt, int expBase) {
    int firstDigit = Integer.parseInt(Integer.toString(binInt).substring(1, 2));
    if (binLength == 0) { 
        return runningResult;
    } else if (firstDigit == 0) {
        return exponentiator((runningResult * runningResult), (binLength - 1), (binInt % (int) Math.pow(10, (int) Math.log10(binInt))), expBase);
    } else {
        return exponentiator((runningResult * runningResult * expBase), (binLength - 1), (binInt % (int) Math.pow(10, (int) Math.log10(binInt))), expBase);
    }
}