private static Date convertStringToDate(String string) {
    Date date = new Date();
    Locale russianLocale = new Locale.Builder().setLanguage("ru").setRegion("RU").build();
    try {
        date = new SimpleDateFormat("dd.MM.yyyy, HH:mm", russianLocale).parse(string);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return date;
}