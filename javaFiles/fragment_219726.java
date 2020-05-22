public String getTime(){
    Locale locale = Controller.request().acceptLanguages().get(0).toLocale();

    DateTime dateTime = new DateTime(betDate, DateTimeZone.UTC);
    dateTime = dateTime.withZone(DateTimeZone.forID("Europe/Paris"));
    return DateTimeFormat.shortTime().withLocale(locale).print(dateTime);
}

public String getDate(){
    Locale locale = Controller.request().acceptLanguages().get(0).toLocale();

    DateTime dateTime = new DateTime(betDate, DateTimeZone.UTC);
    dateTime = dateTime.withZone(DateTimeZone.forID("Europe/Paris"));
    return DateTimeFormat.shortDate().withLocale(locale).print(dateTime);
}