public class Fruit {
    ...
    public static Fruit createFruit(String name) {
        if(name.equalsIgnoreCase("apple"))
            return new Apple();
        if(name.equalsIgnoreCase("orange"))
            return new Orange();
        ...
        return new Fruit(name);
    }
    ...
}