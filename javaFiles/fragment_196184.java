// convert your Calendar object to ZonedDateTime
converted = currentdate.toInstant()
               .atZone(ZoneId.of("America/Denver"))
               .withZoneSameLocal(ZoneOffset.UTC);
// converted is equals to 2017-07-03T11:34:34.508Z

// from ZonedDateTime to Date and Calendar (date will be 11:34 UTC)
Date d = Date.from(converted.toInstant());
Calendar cal = Calendar.getInstance();
cal.setTime(d);

// to get a Date that corresponds to 11:34 in Denver
Date d = Date.from(converted.withZoneSameLocal(ZoneId.of("America/Denver")).toInstant());
Calendar cal = Calendar.getInstance();
cal.setTime(d);