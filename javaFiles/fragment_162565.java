public static void main(String[] args) throws ParseException {
    System.out.println(parseWithOrdinals("1st April,2016"));
    System.out.println(parseWithOrdinals("3rd April,2016"));
    System.out.println(parseWithOrdinals("22nd April,2016"));
}

private static Date parseWithOrdinals(String date) throws ParseException {
    DateFormat format = new SimpleDateFormat("dd MMM,yyyy", Locale.UK);
    String corrected = date.replaceFirst("(\\d+)+.*\\s(.*)", "$1 $2");
    return format.parse(corrected);
}