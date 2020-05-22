import java.lang.reflect.*;

public static void listMethods(Class<?> klazz) {
    System.out.println("Declared methods for " + klazz);
    for (Method m : klazz.getDeclaredMethods()) {
        System.out.println(m);
    }       
}
public static void main(String args[]) {
    listMethods(A.class);
    // Declared methods for class A
    // abstract void A.foo(A)
}