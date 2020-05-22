@Transactional
public Person getPerson(int id) {
// SQL sent to the database:
// Begin transaction

Person person = em.find(Person.class, id);
// SQL sent to the database:
// select p from person p where p.id = id
// the data from the database then gets converted to Java Person class

return person;
}
// after end of the method Spring automatically commits the transaction (not always, it depends on the `propagation` setting)
// SQL sent to the database:
// commit