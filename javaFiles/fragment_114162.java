TimeZone utc = TimeZone.getTimeZone("UTC");
Calendar beginTime = Calendar.getInstance(utc);
// set all values to 0
beginTime.clear();
beginTime.set(2012, 9, 14);
startMillis = beginTime.getTimeInMillis();

Calendar endTime = Calendar.getInstance(utc);
// the event ends right before the next day begins
endTime.clear();
endTime.set(2012, 9, 15);
endMillis = endTime.getTimeInMillis();