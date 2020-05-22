public enum CoffeeSort {
    Coffee("Kaffee") {
        @Override public ACoffee createCoffee() {
           ...
        }
    },
    Espresso("Espresso") { ... },
    Mocca("Mocca") { ... },
    Cappuccino("Cappuccino") { ... },
    LatteMacchiato("Latte Macchiato") { ... },
    DoubleEspresso("doppelter Espresso") { ... };

    private final String stringValue;

    private CoffeeSorts(final String s) {
        stringValue = s;
    }

    @Override
    public String toString() {
        return stringValue;
    }

    public abstract ACoffee createCoffee();
}