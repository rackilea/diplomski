// TODO: Consider what happens if the file runs out half way through a person...
while (x.hasNext()) {
    Person person = new Person();
    person.setFirstName(x.next());
    person.setLastName(x.next());
    person.setStreet(x.next());
    person.setTown(x.next());
    person.setTelephoneNumber(x.next());
    person.setCity(x.next()); // Or whatever...

    Main.addressBook.add(person);
}