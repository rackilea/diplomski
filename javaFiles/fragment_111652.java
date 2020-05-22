public class Main {

    public void run() {
        Child child = A.parent.child1;
    }
}

class A {
    public static Parent parent = new Parent("abc");
}

class Parent {

    public Parent(String s) {
        // Do whatever with string s
    }

    public Child child1 = new Child("efg1");
    public Child child2 = new Child("efg2");
}

class Child {

    public Child(String s) {
        // Do whatever with string s
    }
}