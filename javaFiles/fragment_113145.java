Map<String, String> idToNameMap = persons1.stream()
    .collect(Collectors.toMap(Person1::getId, Person1::getName, (a, b) -> a));
for (Person person : persons) {
    if (idToNameMap.containsKey(person.getId())) {
        person.setName(idToNameMap.get(person.getId()));
    }
}