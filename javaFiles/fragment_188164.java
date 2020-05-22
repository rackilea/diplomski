public static String getWeekBounds(int year, int week){
    Calendar c = Calendar.getInstance();
    c.set(Calendar.WEEK_OF_YEAR, week);
    c.set(Calendar.YEAR, year);
    c.getTime(); //line added that removed the glitch
    int firstDayOfWeek = c.getFirstDayOfWeek();
    c.set(Calendar.DAY_OF_WEEK, firstDayOfWeek);
    String result = new SimpleDateFormat("dd-MM-yy",Locale.getDefault()).format(c.getTime()) + "~";
    int lastDayOfWeek = firstDayOfWeek+6;
    c.set(Calendar.DAY_OF_WEEK, lastDayOfWeek);
    result += new SimpleDateFormat("dd-MM-yy",Locale.getDefault()).format(c.getTime());

    return result;
}