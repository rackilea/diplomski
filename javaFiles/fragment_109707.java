/**
    * Convert Date to Microsoft OLE Automation - OADate type
    * @param date
    * @return
    * @throws ParseException
    */
    public static String convertToOADate(Date date) throws ParseException {
    double oaDate;
    SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
    Date baseDate = myFormat.parse("30 12 1899");
    Long days = TimeUnit.DAYS.convert(date.getTime() - baseDate.getTime(), TimeUnit.MILLISECONDS);

    oaDate = (double) days + ((double) date.getHours() / 24) + ((double) date.getMinutes() / (60 * 24)) + ((double)                     date.getSeconds() / (60 * 24 * 60));
    return String.valueOf(oaDate);
    }