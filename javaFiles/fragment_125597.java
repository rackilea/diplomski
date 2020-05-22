Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
String startFormattedDate = sdf.format(date);
System.out.println(startFormattedDate);
Thread.sleep(10000L);
Date after10Seconds = new Date(); //here
String endFormattedDate = sdf.format(after10Seconds);
System.out.println(endFormattedDate);