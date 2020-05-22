public static void main(String[] args) throws Exception {
    String Input="75.74306816000052";
    String Input2 = "26.910038862000476";
    BigDecimal Output= new BigDecimal(Input).setScale(5, RoundingMode.HALF_EVEN);
    System.out.println(Output.setScale(6)); //75.743070
    BigDecimal Output2= new BigDecimal(Input2).setScale(5, RoundingMode.HALF_EVEN);
    System.out.println(Output2.setScale(6)); //26.910040
}