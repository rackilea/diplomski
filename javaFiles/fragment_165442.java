// remove the unneeded information
String date = date.replace("/Date(", "").replace(")/"); 
String[] dateParts = date.split("[+-]")
//get the date represented by the given millis
Calendar c = Calendar.getInstance();
c.setTime(Long.parseLong(dateParts[0]);
// proceed with formatting to the desired date format.