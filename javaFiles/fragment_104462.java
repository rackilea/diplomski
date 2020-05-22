Date date = new Date();
Calendar calendar = GregorianCalendar.getInstance();
calendat.setTime(date);

if(calendar.get(Calendar.HOUR_OF_DAY) > 5 && calendar.get(Calendar.HOUR_OF_DAY) < 17)
{
    int totalHours = calendar.get(Calendar.HOUR_OF_DAY) - 5;
    int totalMinutes = (totalHours * 60) + calendar.get(Calendar.MINUTE);
}

else
{
    totalHours = 24 - calendar.get(HOUR_OF_DAY) + 5;
    totalMinutes = (totalHours * 60) - (60 - calendar.get(Calendar.MINUTE);
}