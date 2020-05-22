Location location = new Location(LocationType.Paris, "sunny");
Person person = new Person(location, "Timm");

for (Map.Entry<Person, List<Location>> entry : personByLocation.entrySet()) {
    Person p = entry.getKey();
    List<Location> locations = entry.getValue();
    for(Location loc : locations) {
        System.out.println(p + " " + loc);
    }
}