SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
Date d1 = df.parse("09:30:00");
Date d2 = df.parse("15:30:00");
long date1InMilSec = d1.getTime();
long date2InMilSec = d2.getTime();
long half = date1InMilSec + ((date2InMilSec - date1InMilSec) / 2);
Date meanTime = new Date(half); // new Date instance, instead of own calculation
String time = df.format(meanTime);
System.out.println(time);