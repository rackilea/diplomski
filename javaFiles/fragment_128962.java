String time = "1369148661";
long timestampLong = Long.parseLong(time)*1000;
Date d = new Date(timestampLong);
Calendar c = Calendar.getInstance();
c.setTime(d);
int year = c.get(Calendar.YEAR);
int month = c.get(Calendar.MONTH);
int date = c.get(Calendar.DATE);
System.out.println(year +"-"+month+"-"+date);