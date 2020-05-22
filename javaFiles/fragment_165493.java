import java.util.List;

public class Person {
    private String name;
    private List<Person> children;
    public Person() {
    }
    public Person(String name, List<Person> children) {
        this.name = name;
        this.children = children;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Person> getChildren() {
        return children;
    }
    public void setChildren(List<Person> children) {
        this.children = children;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", children=" + children + "]";
    }
}