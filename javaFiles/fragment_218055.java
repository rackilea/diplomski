//simulate your input
Instant input = Instant.parse("2017-11-16T00:00:00Z");
Date d = Date.from(input);    

//transformation code starts here
Instant instant = d.toInstant();

ZonedDateTime localInstant = instant.atZone(ZoneOffset.UTC);
ZonedDateTime sameLocalInBrazil = utcInstant.withZoneSameLocal(ZoneId.of("Brazil/East"));
OffsetDateTime sameInstantUtc = sameLocalInBrazil.toOffsetDateTime()
                                      .withOffsetSameInstant(ZoneOffset.UTC);