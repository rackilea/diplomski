public static void main(String[] args) {
    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    symbols.setDecimalSeparator('.');
    DecimalFormat formatter = new DecimalFormat("#.00", symbols);
    System.out.println(formatter.format(BigDecimal.valueOf(12.456)));
    System.out.println(formatter.format(BigDecimal.valueOf(12L)));
}