private Locale locale = Locale.UK;
// 1. create calendar
private Calendar cal = new GregorianCalendar(locale);
private DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);

public void getThisWeeksDays() {
    // 2. set calendar to the current date
    cal.setTime(new Date());
    cal.setFirstDayOfWeek(Calendar.SUNDAY);

    // 3. set calendars dOW field to the first dOW (last sunday)
    cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());

    for (int i = 0; i < 7; i++) {
        // 4. get some infomation
        String nameOfMonth = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, locale);
        String nameOfDay = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        System.out.println(dayOfMonth + ": " + df.format(cal.getTime()));

        // 5. increase day field; add() will adjust the month if neccessary
        cal.add(Calendar.DAY_OF_WEEK, 1);
    }
}