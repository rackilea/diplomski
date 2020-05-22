String string = "20160112T110000Z";

    String originalStringFormat = "yyyyMMdd'T'HHmmss'Z'";
    String desiredStringFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    SimpleDateFormat readingFormat = new SimpleDateFormat(originalStringFormat);
    SimpleDateFormat outputFormat = new SimpleDateFormat(desiredStringFormat);

    try {
        Date date = readingFormat.parse(string);
        System.out.println(outputFormat.format(date));
    } catch (ParseException e) {

        e.printStackTrace();
    }