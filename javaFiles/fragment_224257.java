public class Animal {
    public void foo() {
        System.out.println("Animal");
    }
}

public class Cat extends Animal {
    public void foo() { // overrides Animal.foo()
        System.out.println("Cat");
    }
}