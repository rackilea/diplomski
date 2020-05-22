for (String tzId : TimeZone.getAvailableIDs()) {
    TimeZone tz = TimeZone.getTimeZone(tzId);
    if (tz.useDaylightTime()) {
        // do something
    }
}