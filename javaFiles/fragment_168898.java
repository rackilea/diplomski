ZoneId PT = ZoneId.of("America/Los_Angeles");

LocalDateTime ldtStart = LocalDateTime.parse("2016-11-06T00:57:01");
ZonedDateTime zdtStartEarly = ldtStart.atZone(PT).withEarlierOffsetAtOverlap();
ZonedDateTime zdtStartLater = ldtStart.atZone(PT).withLaterOffsetAtOverlap();
System.out.println(zdtStartEarly); // 2016-11-06T00:57:01-07:00[America/Los_Angeles]
System.out.println(zdtStartLater); // 2016-11-06T00:57:01-07:00[America/Los_Angeles]

LocalDateTime ldtEnd = LocalDateTime.parse("2016-11-06T01:56:01");
ZonedDateTime zdtEndEarly = ldtEnd.atZone(PT).withEarlierOffsetAtOverlap();
ZonedDateTime zdtEndLater = ldtEnd.atZone(PT).withLaterOffsetAtOverlap();
System.out.println(zdtEndEarly); // 2016-11-06T01:56:01-07:00[America/Los_Angeles]
System.out.println(zdtEndLater); // 2016-11-06T01:56:01-08:00[America/Los_Angeles]