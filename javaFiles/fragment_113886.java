List<Person> people = ...
Map<Name, Person> peopleByName = new HashMap<>();
for (Person person : people) {
  // Name is a simple value class with equality based on its fields
  Name name = new Name(person.getFirstName(), person.getLastName());
  Person firstPersonWithName = peopleByName.get(name);
  if (firstPersonWithName == null) {
    peopleByName.put(name, person);
  } else {
    // or whatever you do to mark a duplicate
    person.setDuplicateOf(firstPersonWithName);
  }
}