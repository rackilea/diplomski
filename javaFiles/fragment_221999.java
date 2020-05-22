class Fruit {
   ...
}

class FruitGeneric<T extends Fruit> extends Fruit {
    public boolean isEqualPrice (T otherFruit) {
        ...
    }
}

class Apple extends FruitGeneric<Apple> {
   ...
}

class Orange extends FruitGeneric<Orange> {
   ...
}