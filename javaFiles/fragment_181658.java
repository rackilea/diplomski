public class Test {
    public static void main(String... args) {
        Drink drink;
        if (args.length == 0) {
            drink = new Beer();
        } else {
            drink = new Rum();
        }
        System.out.println(drink.getBrand());
    }
}

interface Drink {
    public String getBrand();
}

class Beer implements Drink {
    @Override
    public String getBrand() {
        return "BeerBrand"; 
    }
}

class Rum implements Drink {
    @Override
    public String getBrand() {
        return "RumBrand";
    }
}