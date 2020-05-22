DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
// Note --------------------------------------------------------^^^^
Date date = format.parse("2015-07-16T03:58:24.932Z");
// Note trimming --------------------------------^
System.out.println("date: " + date);
System.out.println("timestamp: " + date.getTime());