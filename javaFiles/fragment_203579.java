public static void main(String[] args) {
    Set<String> timeZones = Set.of(TimeZone.getAvailableIDs());
    Set<String> zoneIds = ZoneId.getAvailableZoneIds();
    System.out.println("Extra TimeZone's: " + diff(timeZones, zoneIds));
    System.out.println("Extra ZoneId's: " + diff(zoneIds, timeZones));
}
static Set<String> diff(Set<String> a, Set<String> b) {
    Set<String> diff = new TreeSet<>(a);
    diff.removeAll(b);
    return diff;
}