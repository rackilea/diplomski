class A {
    public static void main(String[] args) {
        System.out.println("A");
    }
}

class B extends A {
    public static void main(String[] args) {
        System.out.println("B");
    }
}

class C extends B {
}

public class Test {
    public static void main(String[] args) {
        C.main(args);  // Will invoke B.main
    }
}