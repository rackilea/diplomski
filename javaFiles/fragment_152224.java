class Fruit {}

class Apple extends Fruit {} 

class Jonathan extends Apple {} 

class Orange extends Fruit {} 

public class Main { 
    public static void main(String[] args) { 
        Fruit[] fruit = new Apple[10];
        boolean alt = (Math.random() < 0.5);

        try { 
            fruit[0] = fruitFactory(alt); 
        } catch(Exception e) { System.out.println(e); } 
    } 

    private static Fruit fruitFactory(boolean apple) {
        if (apple) {
            return new Apple();
        } else {
            return new Orange();
        }
    } 
}