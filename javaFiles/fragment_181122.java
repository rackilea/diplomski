try {
    formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    date = (Date) formatter.parse("2012-08-16T11:07:10.793");
} catch(ParseException e) {
    // It does not match your input
}