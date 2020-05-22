public class Cat {
  Claw claw_;
  public Cat(Claw claw) {claw = claw_;}
  public final void scratch() {
    if (claw_ != null) {
      claw_.scratch(this);
    }
  }
}