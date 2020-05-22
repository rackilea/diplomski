public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private Module module;

    public Student(String firstName, String lastName, int age, Module module) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.module = new Module(module); // Defensive copy
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    // ...and so on for lastName and age...

    public void setModule(Module module) {
        this.module = new Module(module); // Defensive copy
    }
    public Module getModule() {
        return new Module(this.module); // Defensive copy
    }
}