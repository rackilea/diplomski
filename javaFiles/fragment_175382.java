enum Direction {
  NORTH("north"), SOUTH("south"), EAST("east"), WEST("west");

  private final String printableValue;

  Direction(String printableValue) {
    this.printableValue = printableValue;
  }

  @Override
  public String toString() {
    return printableValue;
  }
}