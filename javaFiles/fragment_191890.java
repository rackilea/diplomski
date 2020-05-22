String dateStr = "Thu Jan 19 2012 01:00 PM";
    DateFormat readFormat = new SimpleDateFormat( "EEE MMM dd yyyy hh:mm aaa");

    DateFormat writeFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
    Date date = null;
    try {
       date = readFormat.parse( dateStr );
    } catch ( ParseException e ) {
        e.printStackTrace();
    }

    String formattedDate = "";
    if( date != null ) {
    formattedDate = writeFormat.format( date );
    }

    System.out.println(formattedDate);