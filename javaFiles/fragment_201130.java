public static List<String> findTimeZones(int offsetMilliseconds) {
    List<String> ret = new ArrayList<String>();
    for (String id : TimeZone.getAvailableIDs()) {
        TimeZone zone = TimeZone.getTimeZone(id);
        if (zone.getRawOffset() == offsetMilliseconds ||
            zone.getRawOffset() + zone.getDSTSavings() == offsetMilliseconds) {
            ret.add(id);
        }
    }
    return ret;
}