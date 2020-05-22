package domparserexample.java;

public class Employee {

    private String name;
    private int id;
    private int age;
    private String type;

    public Employee(String name, int id, int age, String type) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.type = type;
    }

    public String toString() {
        return id + ": " + name + ", age: " + age + ", type: " + type;
    }

}