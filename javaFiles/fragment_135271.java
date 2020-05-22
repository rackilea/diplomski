class Sample {

    private static void test_num_to_string() {
        List<String> list = intToStringList(sampleBigInt());
    }

    private static final int DIGITS_PER_STRNG = 10; // DIGITS_PER_STRNG < Integer.MAX_VALUE ( = max String length)
    private static final BigInteger DIVIDER = BigInteger.valueOf(10);

    private static List<String> intToStringList(BigInteger i) {
        List list = new ArrayList();

        while (i.compareTo(BigInteger.ZERO) > 0) {
            String str = "";
            for (int j = 0; j < DIGITS_PER_STRNG; j ++) {
                BigInteger[] divideAndRemainder = i.divideAndRemainder(DIVIDER);
                str = str + String.valueOf(divideAndRemainder[1]);
                i = divideAndRemainder[0];
            }
            list.add(str);
            System.out.println(str);
        }

        return list;
    }

    private static BigInteger sampleBigInt() {
        BigInteger bigInt = BigInteger.valueOf((int) Math.pow(2, 10000));
        int i;
        for (i = 0; i < 10; i ++) {
            bigInt = bigInt.multiply(bigInt);
        }
        return bigInt;
    }
}