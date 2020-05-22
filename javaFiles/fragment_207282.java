class Lunch<Fruittype implements Fruit> {
     public Fruittype fruit;

     public void tasteit() {
         System.out.println("I'm going to eat a "+ fruit.getName() + "!" );
         fruit.taste();
     }
}