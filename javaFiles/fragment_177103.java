class SomeEntity {
  long id;
  String name;

  public SomeEntity(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Overrides
  public String toString() {
    return id + " " + name;
  }
}