List<Map<String, String>> planetsList = new ArrayList<Map<String,String>>();

private void initList() {

planetsList.add(createPlanet("planet", "Mercury"));
planetsList.add(createPlanet("planet", "Venus"));
planetsList.add(createPlanet("planet", "Mars"));
planetsList.add(createPlanet("planet", "Jupiter"));
planetsList.add(createPlanet("planet", "Saturn"));
planetsList.add(createPlanet("planet", "Uranus"));
planetsList.add(createPlanet("planet", "Neptune"));

}

private HashMap<String, String> createPlanet(String key, String name) {
HashMap<String, String> planet = new HashMap<String, String>();
planet.put(key, name);

return planet;
}