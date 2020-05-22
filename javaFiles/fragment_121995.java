private static String insertCommas(BigDecimal number) {
  // for your case use this pattern -> #,##0.00
  DecimalFormat df = new DecimalFormat("#,##0.00");
  return df.format(number);
}

private static String insertCommas(String number) {
  return insertCommas(new BigDecimal(number));
}