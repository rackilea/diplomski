/**
 * Convert Microsoft un OLE Automation - OADate to Java Date.
 * @param date
 * @return
 * @throws ParseException
 */
public static Date convertFromOADate(double d) throws ParseException {
    double  mantissa = d - (long) d;
    double hour = mantissa*24;
    double min =(hour - (long)hour) * 60;
    double sec=(min- (long)min) * 60;


    SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
    Date baseDate = myFormat.parse("30 12 1899");
    Calendar c = Calendar.getInstance();
    c.setTime(baseDate);
    c.add(Calendar.DATE,(int)d);
    c.add(Calendar.HOUR,(int)hour);
    c.add(Calendar.MINUTE,(int)min);
    c.add(Calendar.SECOND,(int)sec);

    return c.getTime();
}