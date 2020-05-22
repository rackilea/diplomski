public static <U extends Calendar> CalendarMatch<U> tpDailyGregorian(
    int h, CalendarFactory<U> factory
) {
    Calendar dt = factory.create(TimeZone.getTimeZone(DEFAULT_TZ_ID));
    dt.clear();
    dt.set(Calendar.HOUR, h);

    // this works because of type inference
    return tpFromCalendar(dt);
}