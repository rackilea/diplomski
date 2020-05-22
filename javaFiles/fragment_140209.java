SimpleDateFormat dateFormatIST = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
    dateFormatIST.setTimeZone(TimeZone.getTimeZone("IST"));

    //Local time zone   
    SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");

    //Time in IST
    Date d = new Date();
    System.out.println(d);
    // Mon Mar 16 16:57:19 CET 2015