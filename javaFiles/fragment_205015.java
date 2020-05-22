public class Person {
    public final String name;

    public Person(String name) {
        this.name = name;
    }
}

Person p = new Person("a");
p.name = "newName"; // COMPILE ERROR name is marked as "final" thus can not be changed.