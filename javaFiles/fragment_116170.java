public static class Student {
  private String firstName;
  private String lastName;

  public void setFirstName(String firstName) {
    this.firstName = (firstName != null) ? firstName
        .trim() : "";
  }

  public void setLastName(String lastName) {
    this.lastName = (lastName != null) ? lastName
        .trim() : "";
  }

  public Student(String firstName, String lastName) {
    setFirstName(firstName);
    setLastName(lastName);
  }

  public Student(String[] names) {
    if (names != null && names.length == 2) {
      setFirstName(names[0]);
      setLastName(names[1]);
    }
  }

  public String toString() {
    return this.lastName + ", " + this.firstName;
  }
}