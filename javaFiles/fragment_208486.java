String offset = "GMT-8:00";
    String date = "15Sep20162040";
    date = date+" "+offset;
    SimpleDateFormat dateFormatter2 = new SimpleDateFormat("ddMMMyyyyHHmm Z");
    SimpleDateFormat offsetDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
    offsetDateFormat2.setTimeZone(TimeZone.getTimeZone(offset));
    String result = offsetDateFormat2.format(dateFormatter2.parse(date));
    System.out.println(result);