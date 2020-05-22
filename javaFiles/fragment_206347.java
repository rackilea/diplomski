public static Date gmttoLocalDate(Date date) {

    String timeZone = Calendar.getInstance().getTimeZone().getID();
    Date local = new Date(date.getTime() + TimeZone.getTimeZone(timeZone).getOffset(date.getTime()));
    return local
}