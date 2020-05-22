class CoffeeService extends SomeFrameworkService {

    private CoffeeComponent coffeeComponent;

    void initComponent() {
        coffeeComponent = DaggerCoffeeComponent
                              .builder()
                              .coffeeModule(new CoffeeModule());
                              .build();
    }

    public CoffeeShop createCoffeeShop() {
        return coffeeComponent.getCoffeeShop(); //equivalent to Injector.getInstance();
    }
}