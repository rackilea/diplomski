DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.ENGLISH);
    Date dateFromDatabase = df.parse("2016-01-12 00:00:00.0");

    DateFormat df2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
    Date dateFromUi = df2.parse("Thu Jan 12 00:00:00 GST 2016");

    compareDates(dateFromDatabase, dateFromUi);