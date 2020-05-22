String dateString = "2016-06-02";
String time = "01:00:00";
String timezone = "Australia/Brisbane";
DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")
        .withZone(DateTimeZone.forID(timezone));
DateTime dateInTimezone = DateTime.parse(dateString+" "+time, formatter);