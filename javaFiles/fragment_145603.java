ZoneId ect = ZoneId.of(ZoneId.SHORT_IDS.get("ECT"));

DateTimeFormatter f1 = DateTimeFormatter.RFC_1123_DATE_TIME;
DateTimeFormatter f2 = f1.withZone(ect);
DateTimeFormatter f3 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
DateTimeFormatter f4 = f3.withZone(ect);

LocalDateTime ldt = LocalDateTime.of(2015, 07, 21, 0, 0, 0, 0);
ZonedDateTime zdt = ZonedDateTime.of(ldt, ect);
Instant ins = zdt.toInstant();

System.out.println(f1.format(ins)); // throws exception (1)
System.out.println(f2.format(ins)); // Tue, 21 Jul 2015 00:00:00 +0200
System.out.println(f3.format(ins)); // throws exception (2)
System.out.println(f4.format(ins)); // 2015-07-21T00:00:00

System.out.println(f1.format(zdt)); // Tue, 21 Jul 2015 00:00:00 +0200
System.out.println(f2.format(zdt)); // Tue, 21 Jul 2015 00:00:00 +0200
System.out.println(f3.format(zdt)); // 2015-07-21T00:00:00
System.out.println(f4.format(zdt)); // 2015-07-21T00:00:00

System.out.println(f1.format(ldt)); // throws exception (3)
System.out.println(f2.format(ldt)); // throws exception (4)
System.out.println(f3.format(ldt)); // 2015-07-21T00:00:00
System.out.println(f4.format(ldt)); // 2015-07-21T00:00:00

ZoneId hst = ZoneId.of(ZoneId.SHORT_IDS.get("HST"));
ZonedDateTime zdt2 = ZonedDateTime.of(ldt, hst);

System.out.println(f1.format(zdt2)); // Tue, 21 Jul 2015 00:00:00 -1000
System.out.println(f2.format(zdt2)); // Tue, 21 Jul 2015 12:00:00 +0200
System.out.println(f3.format(zdt2)); // 2015-07-21T00:00:00
System.out.println(f4.format(zdt2)); // 2015-07-21T12:00:00