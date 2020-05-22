public enum Race {
  DRONE(5), QUEEN(1);

  private final double speed;
  private Race(double speed) { this.speed = speed; }

  public double getSpeed() { return speed; }