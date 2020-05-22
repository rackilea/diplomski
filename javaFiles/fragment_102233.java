public static void main(String[] args) {        
    String realNumber = "234.324823783782"; 

    String[] mySplit = realNumber.split("\\.");

    BigDecimal decimal = new BigDecimal(mySplit[0]);
    BigDecimal real = new BigDecimal(realNumber);
    BigDecimal fraction = real.subtract(decimal);

    System.out.println(String.format("Decimal : %s\nFraction: %s", decimal.toString(),fraction.toString()));

}