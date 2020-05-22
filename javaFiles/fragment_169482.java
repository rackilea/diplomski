public final class Cooking extends SystemOfUnits {
  private static HashSet<Unit<?>> UNITS = new HashSet<Unit<?>>();

  private Cooking() {
  }

  public static Cooking getInstance() {
    return INSTANCE;
  }
  private static final Cooking INSTANCE = new SI();

  public static final BaseUnit<CookingVolume> TABLESPOON = si(new BaseUnit<CookingVolume>("Tbsp"));

  ...

   public static final Unit<CookingVolume> GRAM = TABLESPOON.divide(1000);

}

public interface CookingVolume extends Quantity {
  public final static Unit<CookingVolume> UNIT = Cooking.TABLESPOON;
}