DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    try {
        Date date1 = df.parse("2016-11-18T11:13:43.838-0600Z");
        DateFormat outputFormatter1 = new SimpleDateFormat("dd-MMM-yyyy");
        String output1 = outputFormatter1.format(date1); //
    } catch (ParseException e) {
        e.printStackTrace();
    }