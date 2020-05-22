$ cat *.java
// file Child.java
public class Child extends Parent {
    public Child() {
        System.out.println("  I'm the Child...");
    }
}

// file Driver.java
public class Driver {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.hello();
        Child child = new Child();
    }
}

// file Parent.java
public class Parent {
    public Parent() {
    }
    public void hello() {
        System.out.println("Hello from the parent.");
    }
}