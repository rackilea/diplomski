public class Person {
  private String name;
  private Date dateOfBirth;
  // .. more attributes

  // getters and setters

  // overrides of equals, hashcode and toString
}

public class People implements Set<Person> {
  private Set<Person> persons = new HashSet<Person>();

  public boolean add(Person person) {
    return persons.add(person);
  }

  // more methods for remove, contains, ...
}