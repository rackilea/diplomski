List<String> firstNames = new ArrayList<String>();
Iterator <Person> it = name.iterator(); // shouldn't this be persons.iterator() ?
while (it.hasNext()) {
    Person p = it.next(); // No need to cast
    String firsname = p.getFirstName();
    firstNames.add(firstName);
}