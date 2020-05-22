public class Feline {
    public Feline() {
        System.out.println("Feline");
    }
    public Feline(String type) {
        System.out.println(type);
    }
    ... 
}

public class Cougar extends Feline{
    public Cougar() {
        super("Cougar");
    }
    ...
}