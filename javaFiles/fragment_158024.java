class Delay {
  protected int limit;

  public Delay() {limit = millis();}
  public Delay (int l) {
    limit = millis() + l;
  }

  public boolean expired () {
    if (millis() > limit) { return true; }

    return false;
  }
}