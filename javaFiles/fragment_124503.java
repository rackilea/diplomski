private static Date today()
{
    return zeroTime(new Date());
}

/** this is important to get rid of the time portion, including ms */
private static Date zeroTime(final Date date)
{
    return DateTimeFormat.getFormat("yyyyMMdd").parse(DateTimeFormat.getFormat("yyyyMMdd").format(date));
}

private static Date nextDay(final Date date)
{
    return zeroTime(new Date(date.getTime() + 24 * 60 * 60 * 1000));
}