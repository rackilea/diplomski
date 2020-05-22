public class Person {
    private String name;
    private int age;

    public Person() {
        // JSON parsers need a declared default (no argument) constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}