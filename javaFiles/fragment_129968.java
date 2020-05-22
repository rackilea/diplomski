public static void testDate() 
  {
    DateTimeFormatter df = DateTimeFormat.forPattern("dd MM yyyy HH:mm:ss.SSS Z");
    DateTime temp = df.withOffsetParsed().parseDateTime("30 11 2012 12:08:56.235 +0700");
    DateTimeZone theZone = temp.getZone();

    Date date = temp.toDate();

    DateTime dateTime = new DateTime(date);
    DateTimeFormatter df2 = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSZZ");
    DateTimeFormatter df3 = df2.withZone(theZone);

    System.out.println(dateTime.toString(df2));
    System.out.println(dateTime.toString(df3));

  }