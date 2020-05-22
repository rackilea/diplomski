public static Date getZeroTimeDate(Date fecha) {
    Date res = fecha;
    Calendar calendar = Calendar.getInstance();

    calendar.setTime( fecha );
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);

    res = calendar.getTime();

    return res;
}

Date currentDate = new Date();// get current date           
Date eventDate = tempAppointments.get(i).mStartDate;
int dateMargin = getZeroTimeDate(currentDate).compareTo(getZeroTimeDate(eventDate));