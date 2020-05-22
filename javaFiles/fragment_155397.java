public class PersonImpl {

  private final Person person; // this will be the original entity proxy

  public PersonImpl(Person person) {
    this.person = person;
  }

  // "Implement" ignored functions
  public String getName() {
    return String.format("%s %s", this.person.getFirstName(), this.person.getLastName()); 
  }

  // "Enhance" AO getters/setters
  public void setFirstName(String name) {
    this.person.setFirstName("Foobar");
  }
}