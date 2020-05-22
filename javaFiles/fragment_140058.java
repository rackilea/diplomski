List<Person> people = new ArrayList<Person>();
// Any class that extends person can be added
people.add(new Customer());
people.add(new FieldEngineer());
for (Person person : people) {
    System.out.println(person);
}