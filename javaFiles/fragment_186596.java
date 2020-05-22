String string1 = "Oct 15, 2012 1:07:13 PM";
String string2 = "Oct 23, 2012 03:43:34 PM";

SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy h:mm:ss a", Locale.ENGLISH);

Date date1 = sdf.parse(string1);
Date date2 = sdf.parse(string2);