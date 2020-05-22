String datestring = "2016-05-19 13:07:15 PDT";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss zzz");

LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(datestring));
System.out.println(localDateTime);
// Output: 2016-05-19T13:07:15