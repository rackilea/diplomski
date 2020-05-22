public static void main(final String[] args) {
    VariableDateParser parser = new VariableDateParser();
    DateFormat df = DateFormat.getDateTimeInstance(
        DateFormat.MEDIUM, DateFormat.LONG, Locale.GERMAN);
    System.out.println(df.format(parser.getDate("11")));
    System.out.println(df.format(parser.getDate("11. 10.")));
    System.out.println(df.format(parser.getDate("11. 10. 4")));
    System.out.println(df.format(parser.getDate("11. 10. 2004")));
    System.out.println(df.format(parser.getDate("11. 10. 2004 11")));
    System.out.println(df.format(parser.getDate("11. 10. 2004 11:35")));
    System.out.println(df.format(parser.getDate("11. 10. 2004 11:35:18")));
    System.out.println(df.format(parser.getDate("11. 10. 2004 11:35:18:123")));
    System.out.println(df.format(parser.getDate("11:35")));
    System.out.println(df.format(parser.getDate("11:35:18")));
    System.out.println(df.format(parser.getDate("11:35:18:123")));
}