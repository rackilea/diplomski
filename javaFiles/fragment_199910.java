public static Map<String, String> buildTimeZoneSymbolMap(Locale locale) {
    Map<String, String> timeZoneSymbols = Maps.newLinkedHashMap();
    for (String[] zoneInfo : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
        String timeZone = zoneInfo[0];
        if (!timeZoneSymbols.containsKey(zoneInfo[2])) {
            timeZoneSymbols.put(zoneInfo[2], timeZone);
        }
        if (zoneInfo[4] != null && !timeZoneSymbols.containsKey(zoneInfo[4])) {
            timeZoneSymbols.put(zoneInfo[4], timeZone);
        }
    }
    timeZoneSymbols.put("UTC", "GMT");
    return timeZoneSymbols;
}

public static Map<String, DateTimeZone> buildDateTimeZoneSymbolMap(Locale locale) {
    return Maps.transformValues(buildTimeZoneSymbolMap(locale), input -> DateTimeZone.forTimeZone(TimeZone.getTimeZone(input)));
}

public static final Map<String, DateTimeZone> UK_TIMEZONE_SYMBOLS = ImmutableMap.copyOf(buildDateTimeZoneSymbolMap(Locale.UK));