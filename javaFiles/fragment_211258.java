public static void f(Object object) {
    return object;
}

public static void g() {
    Dog dog = new Dog("Spike");
    System.println(f(dog));
}