public enum UnitEnum {
  ONE(1),
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5);

  public final int quantity;

  UnitEnum(int q) {
     this.quantity = q;
  }

  public int getQuantity() { return this.quantity; }
}