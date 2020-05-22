// src/main/java/pkg/SomeClass.java
public class SomeClass {
    public static void main(String[] args) {
        new SomeClass("a", 2);
    }

    public SomeClass(String a, Integer b) {
        System.out.println("Production constructor called");
    }
}