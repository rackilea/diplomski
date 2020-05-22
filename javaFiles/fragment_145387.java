String firstDate = "26/02/2019";
String firstTime = "00:00 AM";
String secondDate = "26/02/2019";
String secondTime = "12:00 PM";

String format = "dd/MM/yyyy hh:mm a";

SimpleDateFormat sdf = new SimpleDateFormat(format);

Date dateObj1 = sdf.parse(firstDate + " " + firstTime);
Date dateObj2 = sdf.parse(secondDate + " " + secondTime);
System.out.println("Date Start: "+dateObj1);
 System.out.println("Date End: "+dateObj2);

 long dif = dateObj1.getTime(); 
  while (dif < dateObj2.getTime()) {
Date slot = new Date(dif);
System.out.println("Hour Slot --->" + slot);
dif += 3600000;
}