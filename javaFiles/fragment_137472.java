String date1 = "May 22 12:05:41 UTC 2018";
DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
LocalDateTime ldt1 = LocalDateTime.parse(date1, format1);

String date2 = "2018-05-22 12:05:41.512";
DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
LocalDateTime ldt2 = LocalDateTime.parse(date2, format2);

DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss", Locale.ENGLISH);
System.out.println(ldt1.format(format3));
System.out.println(ldt2.format(format3));