private Calendar getPSTTime(Calendar utcTime)
{
    TimeZone americaPacific = TimeZone.getTimeZone("America/Los_Angeles");
    Calendar pacificTime = Calendar.getInstance(americaPacific);
    pacificTime.setTime(utcTime.getTime());
    return pacificTime;
}