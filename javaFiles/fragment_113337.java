class SuperClass {
    private String name;

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }
}

class SubClass extends SuperClass {
    public void showName() {
        System.out.println("My name is " + getName());
    }
}

public class Test {
    public static void main(String[] args) {
        SubClass x = new SubClass();
        x.setName("Test");
        x.showName();
    }
}