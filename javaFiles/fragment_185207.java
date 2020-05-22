public static String date(Locale currentLocale) {
    DateFormat df;
    df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT, currentLocale);
    String formattedDate = df.format(getDateOpened());

    String date = "Opened: " + formattedDate;

    return date;
}

public static String name() {
    String name = "Name: " + getName();
    return name;
}