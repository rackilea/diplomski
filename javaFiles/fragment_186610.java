public interface FruitBasketAdder {

     void addFruit(Fruit fruit, Basket basket);
}


public class AppleBasketAdder implements FruitBasketAdder {

     public void addFruit(Fruit fruit, Basket basket) {

          Apple apple = (Apple) fruit;
          basket.addApple(apple);
          ....
     }
}

public class OrangeBasketAdder implements FruitBasketAdder {
     public void addFruit(Fruit fruit, Basket) {

          Orange orange = (Orange) fruit;
          basket.addOrange(orange);
          ....
     }

}