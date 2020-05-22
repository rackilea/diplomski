private static ThreadLocal<DateFormat> _datetimeFormatter = new ThreadLocal<DateFormat>();

private static DateFormat getDatetimeFormatter()
{
    DateFormat format = _datetimeFormatter.get();
    if (format == null)
    {
        format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        _datetimeFormatter.set(format);
    }
    return format;
}

public static String formatDatetime(Date date)
{
    return getDatetimeFormatter().format(date);
}