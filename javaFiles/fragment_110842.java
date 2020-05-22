Date d = new Date(1527152472);//pass in whatever long value you have to the date constructor
SimpleDateFormat simpleDateFormat =
    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//sets the format you want
TimeZone etTimeZone = TimeZone.getTimeZone("America/New_York");
simpleDateFormat.setTimeZone(etTimeZone);// sets the time zone of the formatter
System.out.println(simpleDateFormat.format(d));//gives the formatted date