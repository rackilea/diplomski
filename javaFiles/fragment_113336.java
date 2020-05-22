class SuperClass {
    String name;

    public void setName(String newName) {
        // This writes to the field in SuperClass
        name = newName;
    }
}

class SubClass extends SuperClass {
    // This *hides* the field in SuperClass
    String name;

    public void showName() {
        // This reads the field from SubClass, which
        // nothing writes to...
        System.out.println("My name is " + name);
    }
}

public class Test {
    public static void main(String[] args) {
        SubClass x = new SubClass();
        x.setName("Test");
        x.showName();
    }
}