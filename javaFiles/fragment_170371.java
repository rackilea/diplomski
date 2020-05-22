public void testDec() {
    DecimalFormat df = new DecimalFormat("#.000");
    DecimalFormatSymbols sym = DecimalFormatSymbols.getInstance();
    sym.setDecimalSeparator(',');
    df.setDecimalFormatSymbols(sym);
    System.out.println(df.format(1234567/1000000.0));
}