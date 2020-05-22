Map<Season, Map<Building, List<Info>>> seasonMap = new TreeMap<>();
for (Building building : buildings) {
    for (Map.Entry<Season, List<Info>> e : building.infosBySeason.entrySet()) {
        Season season = e.getKey();
        List<Info> infos = e.getValue();
        if (!seasonMap.containsKey(season)) {
            seasonMap.put(season, new TreeMap<>());
        }

        seasonMap.get(season).put(building, infos);
    }
}