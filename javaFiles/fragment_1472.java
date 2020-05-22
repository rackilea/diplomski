String date = "Fri, 21 Oct 2016 07:28:00 GMT";

DateTimeFormatter gmtFormat = DateTimeFormatter.RFC_1123_DATE_TIME;
TemporalAccessor parsed = gmtFormat.parse(date);
Instant a = Instant.from(parsed);

System.out.println(a);