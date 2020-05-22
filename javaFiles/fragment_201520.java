static String posixSpecFor(TimeZone tz) {
    Formatter posixSpec = new Formatter();

    float offset = (float) tz.getRawOffset() / (1000 * 60 * 60) * -1;
    posixSpec.format("%s%s%s",
        tz.getDisplayName(false, TimeZone.SHORT),
        offset >= 0 ? "+" : "",
        new DecimalFormat("0.##").format(offset));

    if (tz.observesDaylightTime()) {
        posixSpec.format("%s", tz.getDisplayName(true, TimeZone.SHORT));
    }

    ZoneId zone = tz.toZoneId();

    TemporalField weekOfMonth =
        WeekFields.of(DayOfWeek.SUNDAY, 7).weekOfMonth();
    int thisYear = Year.now(zone).getValue();

    List<ZoneOffsetTransitionRule> rules =
        zone.getRules().getTransitionRules();
    if (rules.size() > 2) {
        rules = rules.subList(0, 2);
    }

    for (ZoneOffsetTransitionRule rule : rules) {
        posixSpec.format(",M%d.%d.%d/%s",
            rule.getMonth().getValue(),
            rule.createTransition(thisYear).getDateTimeBefore().get(
                weekOfMonth),
            rule.getDayOfWeek().getValue() % 7,
            rule.getLocalTime());
    }

    return posixSpec.toString();
}