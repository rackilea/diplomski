public static String formatTest(int areaCode, int exchangeCode, int number) {
    DecimalFormat nf3 = new DecimalFormat("#000");
    DecimalFormat nf4 = new DecimalFormat("#0000");
    if( areaCode != 0)
        return nf3.format(areaCode) + "-" + nf3.format(exchangeCode) + "-" + nf4.format(number);
    else
        return nf3.format(exchangeCode) + "-" + nf4.format(number);
}


public static void main(String[] args) {
    System.out.println(formatTest(12, 90, 8));
    System.out.println(formatTest(1, 953, 1932));
}