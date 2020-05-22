List<Employee> employees = new ArrayList<Employee>();
ArrayList<Object> nonMatchedPersons = new ArrayList<Object>();

Iterator<Person> personIterator = personList.iterator();
while (personIterator.hasNext()) {
    Iterator<PersonNpi> npiIterator = npiList.iterator();
    while(npiIterator.hasNext()) {
        Person person = personIterator.next();
        PersonNpi personNpi = npiIterator.next();
        if (person.equals(personNpi)) {
            employees.add(new Employee(person, personNpi));
            personIterator.remove();
            npiIterator.remove();
        }
    }
}

nonMatchedPersons.addAll(personList);
nonMatchedPersons.addAll(npiList);