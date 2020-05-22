public static void main(String[] args) throws FileNotFoundException {
    String test = "200.4E2";
    String test2 = "200E0";
    String val = new BigDecimal(test).toPlainString();
    String val1 = new BigDecimal(test2).toPlainString();
    System.out.println("" + val);
    System.out.println("" + val1);
}