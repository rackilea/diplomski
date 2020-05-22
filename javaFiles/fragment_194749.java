public static void main(String[] args) throws ParseException {
  Locale locale = java.util.Locale.ITALIAN;
  String valueString = "15,7";
  NumberFormat m_nf = NumberFormat.getInstance(locale);
  m_nf.setMaximumFractionDigits(1);
  Double number = (Double) m_nf.parse(valueString);
}