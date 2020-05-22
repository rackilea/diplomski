public enum Unit {

  PROBE    (),
  STALKER  ("cybernetics core");

  private final String[] requirements;

  Unit(String... requirements) {
      this.requirements  = requirements;
  }

  public String[] requirements() { return requirements; }
}