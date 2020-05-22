Calendar c = Calendar.getInstance();
c.setTime(new Date());

// get the current instant in UTC timestamp
Instant now = DateTimeUtils.toInstant(c);

// convert to some timezone
ZonedDateTime z = now.atZone(ZoneId.of("Europe/Berlin"));

// today is 08/06/2017, so Berlin is in DST (GMT+2)
System.out.println(z); // 2017-06-08T14:11:58.608+02:00[Europe/Berlin]

// testing with a date in January (not in DST, GMT+1)
System.out.println(z.withMonth(1)); // 2017-01-08T14:11:58.608+01:00[Europe/Berlin]