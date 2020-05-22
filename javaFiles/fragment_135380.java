public class BooleanPredicate implements Predicate {
  private boolean value;

  @Override
  public boolean matches(Exchange exchange) {
    return value;
  }

  public void setValue(boolean value) {
    this.value = value;
  }