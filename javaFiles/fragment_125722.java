public int getLastDayOfMonth(String dateString) throws ParseException {
    DateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(dateFormat.parse(dateString));
    return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
}