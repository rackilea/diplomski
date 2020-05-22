public static String toBin (int zahl) {
    char[] digits = { '0','0','0','0','0','0' };
    int currDigitIndex = 5;

    while ( currDigitIndex >= 0 && zahl > 0 ) {
        digits[currDigitIndex] += (zahl % 2);
        currDigitIndex--;
        zahl /= 2;
    }

    return new String(digits);
}