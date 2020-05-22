Map<Id, Person> usersById = new HashMap<>();
Map<Id, Person> managersById = new HashMap<>();
ReadonlyProxyMap<Id, Person> allPersons = new ReadonlyProxyMap<>();

...

allPersons.addMap(usersById);
allPersons.addMap(managersById);

...

Person findArbitraryPerson(Id id) {
    return allPersons.get(myId);
}