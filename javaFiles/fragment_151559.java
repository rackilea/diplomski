List<Location> myLocations = new ArrayList<Location>();
...
if(personByLocation.containsKey(person)) {
    List<Location> storedLocations = personByLocation.get(person);
    storedLocations.addAll(myLocations);
} else {
    personByLocation.put(person, myLocations);
}