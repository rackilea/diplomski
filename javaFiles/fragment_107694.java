public static TimeZone parse(TimeZoneProperty pTimeZoneProperty) {
    TimeZone timeZoneRet = null;    

    if (pTimeZoneProperty != null && pTimeZoneProperty.getValue() != null && !pTimeZoneProperty.getValue().isEmpty()) {
        timeZoneRet = TimeZone.getTimeZone(pTimeZoneProperty.getValue());
    }

    return timeZoneRet;
}