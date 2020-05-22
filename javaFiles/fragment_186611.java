public void addFruitsToTheBasket(List<Fruit> fruits, Basket basket) {

    for(Fruit fruit : fruits) {

        BasketAdder adder = registry.get(fruit.getClass());
        adder.addFruit(fruit, basket);

    }
}