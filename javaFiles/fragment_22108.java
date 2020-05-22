Map<String, List<Person>> personsByName = new HashMap<>();
for (Person p : persons) {
  List<Person> personsForName = personsByName.get(p.getName());
  if (personsByName == null) {
    personsForName = new ArrayList<>();
    personsByName.put(p.getName(), personsForName);
  }
  personsForName.add(p);
}