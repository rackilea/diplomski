// create a simple date format instance
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss");
    // get the time zone of Paskistan country
    TimeZone pakistan = TimeZone.getTimeZone("Asia/Karachi");
    // set the time zone to the date format
    sdf.setTimeZone(pakistan);
    // print the date to the console
    System.err.println(sdf.format(new Date()));