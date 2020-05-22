@Builder(builderMethodName = "studentBuilder")
public Student(
    final String firstName,
    final String lastName,
    final String id,
    final String version) {
    super(id, version);
    this.firstName = firstName;
    this.lastName = lastName;
}