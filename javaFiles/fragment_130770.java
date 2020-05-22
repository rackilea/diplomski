class Superclass {
    public Superclass() {
        someMethod();
    }

    void someMethod() {}
}

class Subclass extends Superclass {
    private int explicit = 0;
    private int implicit;

    public Subclass() {
        System.out.println("explicit: " + explicit);
        System.out.println("implicit: " + implicit);
    }

    @Override void someMethod() {
        explicit = 5;
        implicit = 5;
    }
}

public class Test {
    public static void main(String[] args) {
        new Subclass();
    }
}