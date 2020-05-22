// cut of leading zeros in rDigits:
    while(rIndex < 0 || rDigits[rIndex] == 0) {
        rIndex++;
    }
    return Arrays.copyOfRange(rDigits, rIndex, rDigits.length);
}