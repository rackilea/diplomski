public static DecimalBigInt valueOf(String text, int radix) {
    DecimalBigInt bigRadix = new DecimalBigInt(radix);
    DecimalBigInt value = new DecimalBigInt(); // 0
    for(char digit : text.toCharArray()) {
       DecimalBigInt bigDigit =
           new DecimalBigInt(Character.digit(digit, radix));
       value = value.times(bigRadix).plus(bigDigit);
    }
    return value;
}