class Person {
  public static Person createWithFirstName(String firstName) {
    return new Person(firstName, null, null);
  }
  // etc. - more factory methods

  // private constructor
  private Person(String firstName, String lastName, String nickname) { }

  // useful method
  public String getDisplayName() { }
}