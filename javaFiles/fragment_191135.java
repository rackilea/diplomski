public class FoodFactory {

  public Food getFood(String food) {

    if ("Meat".equals(food)) {
      return new Meat();
    } else if ("Fruit".equals(food)) {
      return new Fruit();
    }
    throw new IllegalArgumentException("No food found with name " + food);
  }
}