System.out.println(oldFashionedDateObject); // Wed Nov 01 00:00:00 GMT 2017
    // first thing, convert the Date to an instance of a modern class, Instant
    Instant pointInTime = oldFashionedDateObject.toInstant();
    // convert to same hour and minute in US/Mountain and then back into UTC
    ZonedDateTime convertedDateTime = pointInTime.atOffset(ZoneOffset.UTC)
            .atZoneSimilarLocal(ZoneId.of("US/Mountain"))
            .withZoneSameInstant(ZoneOffset.UTC);
    System.out.println(convertedDateTime); // 2017-11-01T06:00Z

    // only assuming you absolutely and indispensably need an old-fashioned Date object back
    oldFashionedDateObject = Date.from(convertedDateTime.toInstant());
    System.out.println(oldFashionedDateObject); // Wed Nov 01 06:00:00 GMT 2017