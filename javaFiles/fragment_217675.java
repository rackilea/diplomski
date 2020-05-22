String gmtTime = "20140917-18:55:25";
DateTime dateTimeGMT =
    DateTimeFormat.forPattern("yyyyMMdd-HH:mm:ss").withZoneUTC().parseDateTime(gmtTime);
System.out.println("Time in GMT " + dateTimeGMT); // Time in GMT 2014-09-17T18:55:25.000Z

System.out.println(
    "Time in EST "
    + DateTimeFormat.forPattern("yyyyMMdd-HH:mm:ss").withZone(
        DateTimeZone.forID("America/New_York")
    ).print(dateTimeGMT)
); //Time in EST 20140917-14:55:25