public static Calendar getInstance()
{
    Calendar cal = createCalendar(TimeZone.getDefaultRef(), Locale.getDefault(Locale.Category.FORMAT));
    cal.sharedZone = true;
    return cal;
}