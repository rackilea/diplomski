private static final BigInteger BIG_INTEGER_62 = BigInteger.valueOf(62);

public static void main(String[] args) {
    System.out.println(encryptInteger(BigInteger.valueOf(0)));
    System.out.println(encryptInteger(BigInteger.valueOf(1)));
    System.out.println(encryptInteger(BigInteger.valueOf(62)));
    System.out.println(encryptInteger(BigInteger.valueOf(63)));
    System.out.println(encryptInteger(BIG_INTEGER_62.pow(16).subtract(BigInteger.valueOf(1))));
}

private static String encryptInteger(BigInteger number) {
    StringBuilder builder = new StringBuilder(16);
    for(int i = 0; i < 16; i++) {
        builder.append(intToChar(number.divide(BIG_INTEGER_62.pow(i)).mod(BIG_INTEGER_62).intValue()));
    }
    return builder.reverse().toString();
}

private static char intToChar(int value) {
    if(value < 0)
        return '<';
    if(value < 10)
        return (char) ('0' + value);
    if(value < 36)
        return (char) ('a' - 10 + value);
    if(value < 62)
        return (char) ('A' - 36 + value);
    return '>';
}