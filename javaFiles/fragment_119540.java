Map<String, Person> personMap = new HashMap<>();
//Assuming people is declared rightfully as List<Person> rather than just List
for (Person people : people) {
    personMap.put(person.getName(), person);
}
List<Person> results = new ArrayList<>();
for (String name : names) {
    if (personMap.containsKey(name)) {
        results.add(personMap.get(name));
    }
}
//in case you need to work with people only
people.clear();
people.addAll(results);