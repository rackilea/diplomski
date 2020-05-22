public enum Part {
  ROTOR("This is a rotor");

  private final String name;

  Part(final String name) {
      this.name = name;
  } 

  @Override
  public String toString() {
      return name;
  }
}