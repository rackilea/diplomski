DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_DATE_TIME;

OffsetDateTime offsetDateTime = OffsetDateTime.parse("2015-10-27T16:22:27.605-07:00", timeFormatter);

Date date = Date.from(Instant.from(offsetDateTime));
System.out.println(date);