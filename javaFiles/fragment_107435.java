String myDate = "Wed Jun 27 12:33:00 CDT 2018";
    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
    SimpleDateFormat dateFormat_2 = new SimpleDateFormat("MMMM-dd-yyyy h:mm:ss a z", Locale.US);
    dateFormat_2.setTimeZone(TimeZone.getTimeZone("GMT"));

    Date d = dateFormat.parse(myDate);
    dateFormat_2.format(d);
    System.out.println(dateFormat_2.format(d));