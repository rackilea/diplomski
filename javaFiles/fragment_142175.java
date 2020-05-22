String input1 = "2016-12-01T16:30:59.264448";
String input2 = "2016-12-01T16:30:59";

DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss[.SSSSSS]");

LocalDateTime ldt1 = LocalDateTime.parse(input1, dtf); // 2016-12-01T16:30:59.264448
LocalDateTime ldt2 = LocalDateTime.parse(input2, dtf); // 2016-12-01T16:30:59