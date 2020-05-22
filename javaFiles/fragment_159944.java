public static Date firstOfWeek(Calendar cal) {
    Calendar copy = new GregorianCalendar( 
        cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
    copy.set(Calendar.DAY_OF_WEEK, copy.getFirstDayOfWeek());
    return copy.getTime();
}