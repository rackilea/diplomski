LocalDateTime now = LocalDateTime.now();
String format1 = now.format(DateTimeFormatter.ISO_DATE_TIME);
String format2 = now.atZone(ZoneId.of("GMT")).format(DateTimeFormatter.RFC_1123_DATE_TIME);
String format3 = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss", Locale.ENGLISH));

System.out.println(format1);
System.out.println(format2);
System.out.println(format3);