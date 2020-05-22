DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
    DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");

    try {
        //This will give you the desired output
        df2.format(df.parse("Fri Jun 17 12:31:00 GMT+07:00 2016"));
    } catch (ParseException e) {            
        e.printStackTrace();
    }