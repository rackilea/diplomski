public static void main(String[] args) {
    Locale chileLocale = new Locale("es", "CL");
    DecimalFormat formatter = (DecimalFormat) DecimalFormat.getInstance(chileLocale);

    char sep = formatter.getDecimalFormatSymbols().getDecimalSeparator();
    char grp = formatter.getDecimalFormatSymbols().getGroupingSeparator();

    System.out.println("Separator: " + sep + " Grouping: " + grp);
}