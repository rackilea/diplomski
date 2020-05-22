public class Parent {
    private String name;

    public String getName() {
        return name;
    }
}

public class Child extends Parent {
    private String name;

    public String getName() {
        return name;
    }

    public void printNames() {
        System.out.println("I'm " + this.name);
        System.out.println("My father is " + super.getName());
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        ReflectionTestUtils.setField(child,Parent.class, "name", "fatah",String.class);
        ReflectionTestUtils.setField(child,Child.class, "name", "abdul",String.class);
        child.printNames();
    }
}