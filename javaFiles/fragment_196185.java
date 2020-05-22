// convert Calendar to ZonedDateTime 
converted = DateTimeUtils.toInstant(currentdate)
                .atZone(ZoneId.of("America/Denver"))
                .withZoneSameLocal(ZoneOffset.UTC);
// converted is equals to 2017-07-03T11:34:34.508Z

// convert ZonedDateTime to Date (date will be 11:34 UTC)
Date d = DateTimeUtils.toDate(converted.toInstant());
Calendar c = DateTimeUtils.toGregorianCalendar(converted);

// to get a Date that corresponds to 11:34 in Denver
Date d = DateTimeUtils.toDate(converted.withZoneSameLocal(ZoneId.of("America/Denver")).toInstant());
Calendar c = DateTimeUtils.toGregorianCalendar(converted.withZoneSameLocal(ZoneId.of("America/Denver")));