ZoneId zoneId = ZoneId.of("Australia/Sydney");
ZoneRules rules = zoneId.getRules();

ZoneOffsetTransition nextTransition = rules.nextTransition(Instant.now());
System.out.println("Next transition at: " +
        nextTransition.getInstant().atZone(zoneId));

ZoneOffsetTransition nextNextTransition =
        rules.nextTransition(nextTransition.getInstant());
System.out.println("Next transition after that at: " +
        nextNextTransition.getInstant().atZone(zoneId));