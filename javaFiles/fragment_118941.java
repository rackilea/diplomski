public static void main(String[] args) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date procDate = sdf.parse("2016-01-01");
    Calendar cal = Calendar.getInstance(Locale.UK);
    cal.setFirstDayOfWeek(Calendar.SUNDAY);
    cal.setTime(procDate);
    cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY); //Starting day of week
    System.out.println(cal.get(Calendar.WEEK_OF_YEAR) ); 
    System.out.println(cal.get(Calendar.YEAR) );

    procDate = sdf.parse("2016-12-27");
    cal.setTime(procDate);
    cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY); //Starting day of week
    System.out.println(cal.get(Calendar.WEEK_OF_YEAR) ); 
    System.out.println(cal.get(Calendar.YEAR) );            
}