Calendar calendar = Calendar.getInstance();
 calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
 calendar.set(Calendar.HOUR_OF_DAY, 23);//not sure this is needed
 long endOfMonth = calendar.getTimeInMillis();
 //may need to reinitialize calendar, not sure
 calendar = Calendar.getInstance();
 calendar.set(Calendar.DATE, 1);
 calendar.set(Calendar.HOUR_OF_DAY, 0);
 long startOfMonth = calendar.getTimeInMillis();
 calendarView.setMaxDate(endOfMonth);
 calendarView.setMinDate(startOfMonth);