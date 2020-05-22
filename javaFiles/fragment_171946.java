//dayOfWeekToSet is a constant from the Calendar class
//c is the calendar instance
public static void SetToNextDayOfWeek(int dayOfWeekToSet, Calendar c){
    int currentDayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            //add 1 day to the current day until we get to the day we want
    while(currentDayOfWeek != dayOfWeekToSet){
        c.add(Calendar.DAY_OF_WEEK, 1);
        currentDayOfWeek = c.get(Calendar.DAY_OF_WEEK);
    }
}

  //usage:
  Calendar c = Calendar.getInstance();
  System.out.println(c.getTime());
  SetToNextDayOfWeek(Calendar.THURSDAY,c);
    System.out.println(c.getTime());