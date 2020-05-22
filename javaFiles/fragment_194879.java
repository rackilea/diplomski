public String getDateFromDateTime(Date date, Boolean display) {

    DateTimeFormatter dtFormatter;

    if (display)
        dtFormatter = DateTimeFormat.forPattern("MM/dd/yyyy");
    else
        dtFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");

    DateTimeZone timeZone = DateTimeZone.forID("US/Eastern");
    DateTime dt = new DateTime(date, timeZone);
    String myDate = dt.toString(dtFormatter);

    return myDate;
}