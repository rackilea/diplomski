LocalDateTime ldt = LocalDateTime.now().plusDays(1);
DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
System.out.println(ldt);
// Output "2018-05-12T17:21:53.658"

String formatter = formmat1.format(ldt);
System.out.println(formatter);
// 2018-05-12