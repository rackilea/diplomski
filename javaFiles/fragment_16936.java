Calendar start_calendar = Calendar.getInstance();
Calendar end_calendar = Calendar.getInstance();
end_calendar.set(2016, 07, 1); // 10 = November, month start at 0 = January

long start_millis = start_calendar.getTimeInMillis(); //get the start time in milliseconds
long end_millis = end_calendar.getTimeInMillis(); //get the end time in milliseconds
long total_millis = (end_millis - start_millis); //total time in milliseconds