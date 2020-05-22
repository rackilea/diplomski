DateFormat dateFormatter = new SimpleDateFormat("yyyy-MMM-dd");
dateFormatter.setLenient(false);
String dateStr = "2012-Dec-21";
Date date = dateFormatter.parse(dateStr);
Calendar calendar = Calendar.getInstance();
calendar.setTime(date);
int month = calendar.get(Calendar.MONTH);