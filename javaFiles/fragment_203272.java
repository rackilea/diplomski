ZonedDateTime now = ZonedDateTime.now();
ZonedDateTime chicago = now.withZoneSameInstant(ZoneId.of("America/New_York"));
System.out.println("Chicago: " + chicago);
System.out.println("Chicago formated: " + chicago.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL)));

ZonedDateTime tokyo = now.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
System.out.println("Tokyo: " + tokyo);
System.out.println("Tokyo formated: " + tokyo.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL)));