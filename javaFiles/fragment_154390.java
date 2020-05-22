public boolean isBankHoliday(java.util.Date d) {
    Calendar c = new GregorianCalendar();
    c.setTime(d);
    if((Calendar.SATURDAY == c.get(c.DAY_OF_WEEK)) || (Calendar.SUNDAY == c.get(c.DAY_OF_WEEK)) || bankHolidays.contains(dString)) {
        return (true);
    } else {
        return false;
    }
}