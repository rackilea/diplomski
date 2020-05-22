public class MissingZonesProvider extends ZoneRulesProvider {

    private Set<String> missingIds = new HashSet<>();

    public MissingZonesProvider() {
        missingIds.add("America/Punta_Arenas");
        missingIds.add("Europe/Saratov");
        // add all others
    }

    @Override
    protected Set<String> provideZoneIds() {
        return this.missingIds;
    }

    @Override
    protected ZoneRules provideRules(String zoneId, boolean forCaching) {
        ZoneRules rules = null;
        if ("America/Punta_Arenas".equals(zoneId)) {
            rules = // create rules for America/Punta_Arenas
        }
        if ("Europe/Saratov".equals(zoneId)) {
            rules = // create rules for Europe/Saratov
        }
        // and so on

        return rules;
    }

    // returns a map with the ZoneRules, check javadoc for more details
    @Override
    protected NavigableMap<String, ZoneRules> provideVersions(String zoneId) {
        TreeMap<String, ZoneRules> map = new TreeMap<>();
        ZoneRules rules = provideRules(zoneId, false);
        if (rules != null) {
            map.put(zoneId, rules);
        }
        return map;
    }
}