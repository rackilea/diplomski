public class Pancake implements Dish {
  @Override
  public boolean shouldEat() {
     return false;
  }
}

public class Carrot implements Dish {

 @Override
 public boolean shouldEat() {
     return true;
  }
}