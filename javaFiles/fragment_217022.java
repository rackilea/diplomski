String isoDateTime = "2014-09-14T17:00:00+00:00";
ZonedDateTime fromIsoDate = ZonedDateTime.parse(isoDateTime);
ZoneOffset offset = ZoneOffset.of("+09:30");
ZonedDateTime acst = fromIsoDate.withZoneSameInstant(offset);

System.out.println("Input:  " + fromIsoDate);
System.out.println("Output: " + acst.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));