DateTimeFormatter DATE_FORMAT =
    new DateTimeFormatterBuilder().appendPattern("uuuu-MM-dd HH:mm:ss.S").toFormatter();
LocalDateTime ldt = LocalDateTime.parse("2017-01-12 00:00:00.0", DATE_FORMAT);
System.out.println(ldt); // 2017-01-12T00:00

System.out.println(ldt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); // 12/01/2017