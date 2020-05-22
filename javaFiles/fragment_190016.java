SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM yyyy");
Date date = (dateFormat).parse("March 2014");
Calendar calendar = Calendar.getInstance();
calendar.setTime(date);
int noOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
String properFormattedDate = simpleDateFormat.format(date);
System.out.println(properFormattedDate+"-"+String.valueOf(noOfDays));