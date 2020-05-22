public class Person {
  private final String firstName;
  private final String lastName;
  private final Date dateOfBirth;

  public Person(String firstName, String lastName, Date dateOfBirth) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth == null ? null new Date(dateOfBirth.getTime());
  }

  public String getFirstName() { return firstName; }
  public String getLastName() { return lastName; }
  public Date getDateOfBirth() { return dateOfBirth == null ? null : new Date(dateOfBirth.getTime()); }

  public Person withFirstName(String firstName) {
    return new Person(firstName, lastName, dateOfBirth);
  }

  public Person withLastName(String lastName) {
    return new Person(firstName, lastName, dateOfBirth);
  }

  public Person withDateOfBirth(Date dateOfBirth) {
    return new Person(firstName, lastName, dateOfBirth);
  }
}