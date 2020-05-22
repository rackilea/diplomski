public interface Mammal {
}

public class Container {
    Mammal object;
    Container(Mammal a) {
        object = a;
    }

    Mammal getObject() {
        return object;
    }
}

public class Cat implements Mammal {...
public class Dog implements Mammal {...
public class Person implements Mammal {...