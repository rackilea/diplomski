public class Person {
  String firstName;
  String lastName;

  /** the "real" hashCode() */
  public int hashCode() {
    return firstName.hashCode() + 1234 * lastName.hashCode();
  }
}

public class PersonWrapper1 {
  Person person;

  public int hashCode() {
    return person.firstName.hashCode();
  }
}

public class PersonWrapper2 {
  Person person;

  public int hashCode() {
    return person.lastName.hashCode();
  }
}