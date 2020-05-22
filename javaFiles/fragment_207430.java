SimpleDateFormat dateFormatGmt = new SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    Calendar presentCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT")); // <-- here
    System.out.println("With Cal.."
            + dateFormatGmt.format(presentCal.getTime())); // <-- you use it 
                                                           // here.
    String currentDateTimeString = dateFormatGmt.format(new Date());
    System.out.println("With format.." + currentDateTimeString);