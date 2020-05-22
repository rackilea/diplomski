String date = "06-04-2007 07:05:00.999";
SimpleDateFormat fmt = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss.S");
Date myDate = fmt.parse(date);

System.out.println(myDate); 
long timestamp = myDate.getTime();
System.out.println(timestamp);