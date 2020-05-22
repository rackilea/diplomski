public static void main(String[] args) {
    final BigInteger original = new BigInteger("27");
    final String converted = original.toString(16);
    final BigInteger convertedBack = new BigInteger(converted, 16);

    System.out.println("original = [" + original.toString() + "]");
    System.out.println("converted = [" + converted + "]");
    System.out.println("convertedBack = [" + convertedBack.toString() + "]");
}