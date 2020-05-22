SimpleDateFormat sdf = new SimpleDateFormat(
            "EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
Date parsedDate = null;
try {
    parsedDate = sdf.parse("Thu Jan 26 15:05:48 COT 2012");
    System.out.println(parsedDate);
} catch (ParseException e) {
    e.printStackTrace();
}