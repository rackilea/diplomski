public class Person extends Base {

    protected Person(){}

    public void handle(String name, int age) {
        // Expose a type safe interface to the world
        super.handle(name, age);
    }

}