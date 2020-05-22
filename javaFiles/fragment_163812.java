public abstract class Car {
    public boolean isCar() {
        return true;
    }
}

public class Ford extends Car {
    public boolean isFord() {
        return true;
    }
}

public class Audi extends Car {
   public boolean isAudi() {
        return true;
   }
}

System.out.println("Is Ford a car ? "+new Ford().isCar());
System.out.println("Is Audi a car ? "+new Audi().isCar());
System.out.println("Is Ford a ford ? "+new Ford().isFord());
System.out.println("Is Audi a ford ? "+new Audi().isFord());