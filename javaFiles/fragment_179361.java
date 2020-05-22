private static String getMonth(String date) throws ParseException{  
    Date d = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(date);
    Calendar cal = Calendar.getInstance();
    cal.setTime(d);
    String monthName = new SimpleDateFormat("MMMM").format(cal.getTime());
    return monthName;
}