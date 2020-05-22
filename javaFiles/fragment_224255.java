public class Animal {
    public static void foo() {
        System.out.println("Animal");
    }
}

public class Cat extends Animal {
    public static void foo() {  // hides Animal.foo()
        System.out.println("Cat");
    }
}