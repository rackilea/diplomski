long calID = 3;

 ContentResolver cr = getContentResolver();
 ContentValues values = new ContentValues();
 values.put(CalendarContract.Events.DTSTART, beginTime.getTimeInMillis());                        
 values.put(CalendarContract.Events.ALL_DAY,false);
 values.put(CalendarContract.Events.TITLE, projectName);                         
 values.put(CalendarContract.Events.EVENT_LOCATION,projectAddress);
 values.put(CalendarContract.Events.DESCRIPTION, eventDetail);                           
 values.put(CalendarContract.Events.CALENDAR_ID, calID);                           
 values.put(CalendarContract.Events.EVENT_TIMEZONE,"America/Los_Angeles");
 values.put(CalendarContract.Events.DURATION,"+P1H");
 cr.insert(CalendarContract.Events.CONTENT_URI, values);
 Utility.getInstance().showSnackBar(rl_main, "Event addded to calendar 
  successfully!");