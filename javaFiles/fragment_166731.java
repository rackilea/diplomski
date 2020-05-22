// get all the holidays as java.util.Date
DiaFestivoDTO dia = new DiaFestivoDTO();
List<Date> holidays = dia.getAllNationalHolidays();

// get the current date without the hours, minutes, seconds and millis
Calendar cal = Calendar.getInstance();
cal.set(Calendar.HOUR_OF_DAY, 0);
cal.set(Calendar.MINUTE, 0);
cal.set(Calendar.SECOND, 0);
cal.set(Calendar.MILLISECOND, 0);

// iterate over the dates from now and check if each day is a business day
int businessDayCounter = 0
while (businessDayCounter < 3) {
    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
    if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY && !holidays.contains(cal.getTime())) {
        businessDayCounter++;
    }
    cal.add(Calendar.DAY_OF_YEAR, 1);
}
Date threeBusinessDaysFromNow = cal.getTime();