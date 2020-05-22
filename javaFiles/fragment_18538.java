public static void main(String[] args) {
  double dWithFloat = Double.parseDouble(Double.toString(Float.parseFloat("27.86753")));
  double dJustParsed = Double.parseDouble("27.86753");
  System.out.println(dWithFloat);
  System.out.println(dJustParsed);

  BigDecimal bigFromFloat = new BigDecimal(dWithFloat);
  BigDecimal bigJustParsed = new BigDecimal(dJustParsed);
  System.out.println(bigFromFloat); 
    // prints the exact value from the double,
    // doesn't round or truncate like Double.toString
  System.out.println(bigJustParsed);