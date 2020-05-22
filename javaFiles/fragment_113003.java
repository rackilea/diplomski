ZonedDateTime zdt = ZonedDateTime.ofLocal(
    LocalDateTime.of(
        dt.getYear(),
        dt.getMonthOfYear(),
        dt.getDayOfMonth(),
        dt.getHourOfDay(),
        dt.getMinuteOfHour(),
        dt.getSecondOfMinute(),
        dt.getMillisOfSecond() * 1_000_000),
    ZoneId.of(dt.getZone().getID(), ZoneId.SHORT_IDS),
    ZoneOffset.ofTotalSeconds(dt.getZone().getOffset(dt) / 1000));