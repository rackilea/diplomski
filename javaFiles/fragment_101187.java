public class FruitOnSale {

    private Fruit fruit;     
    private int price;

    public FruitOnSale(Fruit fruit, int price) {
        this.fruit = new Fruit(fruit.getName());
        this.price = price;
    }

    public Fruit getFruit() {
        return Fruit(fruit.getName());
    }
}