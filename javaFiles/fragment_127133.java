static final String[] MONTHS =
    { "JAN", "FEV", "MAR", "AVR", "MAI", "JUIN", "JUIL", "AOÛ", "SEP", "OCT", "NOV", "DEC" };

public static void main(String[] args) throws ParseException {

    String s = "MERMAR17 - LUNJUIL14";
    String[] parts = s.split(" - ");

    SimpleDateFormat parser = new SimpleDateFormat("EEEMMMdd yyyy", Locale.FRENCH);
    System.out.println(parser.format(new GregorianCalendar(2015, 2, 18).getTime()));
    // shows deviation between your input and JDK-resources: mer.mars18 2015

    int m0 = parse(parts[0]);
    int m1 = parse(parts[1]);
    Date d0 =
        new GregorianCalendar(
            2000,
            m0,
            Integer.parseInt(parts[0].substring(3 + MONTHS[m0].length()))
        ).getTime();
    Date d1 =
        new GregorianCalendar(
            2000,
            m1,
            Integer.parseInt(parts[1].substring(3 + MONTHS[m1].length()))
        ).getTime();

    SimpleDateFormat format = new SimpleDateFormat("dd/MM");
    String result = format.format(d0) + " - " + format.format(d1);
    System.out.println(result); // 17/03 - 14/07

}

private static int parse(String input) throws ParseException {
    for (int i = 0; i < 12; i++) {
        if (input.substring(3).startsWith(MONTHS[i])) {
            return i;
        }
    }
    throw new ParseException("Cannot parse month abbreviation in: " + input, 3);
}