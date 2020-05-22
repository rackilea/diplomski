public String toString() {
    // TODO: equivalent to the following one-liner, though that's slower on stingray
    // at 476us versus 69us...
    //   return new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(d, Locale.US);
    LocaleData localeData = LocaleData.get(Locale.US);
    TimeZone tz = TimeZone.getDefault();
    Calendar cal = new GregorianCalendar(tz, Locale.US);
    cal.setTimeInMillis(milliseconds);
    StringBuilder result = new StringBuilder();
    result.append(localeData.shortWeekdayNames[cal.get(Calendar.DAY_OF_WEEK)]);
    result.append(' ');
    result.append(localeData.shortMonthNames[cal.get(Calendar.MONTH)]);
    result.append(' ');
    appendTwoDigits(result, cal.get(Calendar.DAY_OF_MONTH));
    result.append(' ');
    appendTwoDigits(result, cal.get(Calendar.HOUR_OF_DAY));
    result.append(':');
    appendTwoDigits(result, cal.get(Calendar.MINUTE));
    result.append(':');
    appendTwoDigits(result, cal.get(Calendar.SECOND));
    result.append(' ');
    result.append(tz.getDisplayName(tz.inDaylightTime(this), TimeZone.SHORT, Locale.US));
    result.append(' ');
    result.append(cal.get(Calendar.YEAR));
    return result.toString();
}