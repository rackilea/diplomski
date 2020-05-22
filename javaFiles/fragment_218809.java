select person.id, person.name, email.email from person person
left join email on person.id = email.person_id

...

Map<Long, Person> personsById = new HashMap<>();
while (rs.next()) {
    Long id = rs.getLong("id");
    String name = rs.getString("name");
    String email = rs.getString("email");
    Person person = personsById.get(id);
    if (person == null) {
        person = new Person(id, name);
        personsById.put(person.getId(), person);
    }
    person.addEmail(email);
}
Collection<Person> persons = personsById.values();