private CoffeeComponent coffeeComponent;

void initComponent() {
    coffeeComponent = DaggerCoffeeComponent
                         .builder()
                         .coffeeModule(new CoffeeModule())
                         .build();
}

void makeCoffee() {  
    CoffeeShop coffeeShop = new CoffeeShop();
    coffeeComponent.inject(coffeeShop); //inject members of coffeeShop
    coffeeShop.makeCoffee();
}