public static String testDate() throws ClassNotFoundException,
    ReflectiveOperationException, Exception {

    if (getDayId() == 1) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(getdate()); // Calling getDate() method and setting the date before subtracting 2 days.
        cal.add(Calendar.DATE, -2);
        return dateFormat.format(cal.getTime());
    }
    return null;
}