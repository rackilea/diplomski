enum Speed {
  FAST(5.0f), WALK(2.0f), STOP(0.0f);

  private final float amount;
  private Speed(flaot a) { this.amount = a; }
  public float getAmount() {
    return amount;
  }
}