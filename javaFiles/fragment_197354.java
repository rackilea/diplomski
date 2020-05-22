String dateStr = ""
//put your input in this string in some format/ example:
//dateSttr = year + "." + month + "." + day + " " + hour + ":" + minute;
//It is better to use StringBuilder

DateFormat inputFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm");
//note that hh is 12h-format and HH is 24h-format
DateFormat outputFormat1 = new SimpleDateFormat("your_outputFormat");
DateFormat outputFormat2 = new SimpleDateFormat("your_another_outputFormat");
Date date = inputFormat.parse(dateStr);
String o1, o2;
o1 = outputFormat1.format(date);
o2 = outputFormat2.format(date);
//o1 and o2 is your result.