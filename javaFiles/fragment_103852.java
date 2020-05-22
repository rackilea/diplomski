calendar.setTime(myDate);
 int dayOfWeek=calendar.get(Calendar.DAY_OF_WEEK);
 if(dayOfWeek==Calendar.MONDAY)
    calendar.add(Calendar.DAY_OF_YEAR, -3); 
 else
 if(dayOfWeek==Calendar.SUNDAY)
    calendar.add(Calendar.DAY_OF_YEAR, -2);
 else
    calendar.add(Calendar.DAY_OF_YEAR, -1);