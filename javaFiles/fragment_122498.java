private Timestamp getTimestamp(DateTime dt)
{
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.YEAR,         dt.getYear());
    cal.set(Calendar.MONTH,        dt.getMonth());
    cal.set(Calendar.DAY_OF_MONTH, dt.getDay());
    cal.set(Calendar.HOUR_OF_DAY,  dt.getHours());
    cal.set(Calendar.MINUTE,       dt.getMinutes());
    cal.set(Calendar.SECOND,       dt.getSeconds());

    return new Timestamp(cal.getTimeInMillis());
}