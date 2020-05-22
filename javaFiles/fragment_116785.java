public class PersonBuilder {
  private String firstName;
  // and others...

  public PersonBuilder() {
    // no arguments necessary for the builder
  }

  public PersonBuilder firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public Person build() {
    // here (or in the Person constructor) you could validate the data
    return new Person(firstName, ...);
  }
}