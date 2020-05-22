public static void main(String[] args) {
    float f = 1234567.99f;
    double d = 1234567.99d;
    System.out.println(new BigDecimal(f));
    System.out.println(new BigDecimal(d));
}