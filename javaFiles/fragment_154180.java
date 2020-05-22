List<Person> people = new ArrayList<Person>();
// populate people

public Person login(String username, String password) {
    for (Person person : people) {
       if (person.getUser().equalsIgnoreCase(username) &&
           person.getPass().equals(password))
           return person;
    }
    return null;
}