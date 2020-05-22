Date testDate = ??? //Replace with whatever source you are using
Calendar testDateCalendar = Calendar.getInstance();
testDateCalendar.setTime(testDate);

Date today = new Date();
Calendar endOfDay = Calendar.getInstance();  //Initiates to current time
endOfDay.setTime(today);
endOfDay.set(Calendar.HOUR_OF_DAY, 23);
endOfDay.set(Calendar.MINUTE, 59);
endOfDay.set(Calendar.SECOND, 59);

Calendar startOfDay = Calendar.getInstance();
startOfDay.setTime(today);
startOfDay.set(Calendar.HOUR_OF_DAY, 0);
startOfDay.set(Calendar.MINUTE, 0);
startOfDay.set(Calendar.SECOND, 0);

if (startOfDay.before(testDateCalendar) && endOfDay.after(testDateCalendar))
{
//Whatever
} else {
//Failure
}