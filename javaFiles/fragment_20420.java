public class SubClass extends SuperClass {
    SubClass(String str) {
    }

    SubClass() {
    }

    public static void main(String[] args) {
        new SubClass("hello");
    }
}

abstract class SuperClass {
    SuperClass() {
        System.out.println("I am SuperClass()");
    }

    SuperClass(String str) {
        System.out.println("I am SuperClass(String str)");
    }
}