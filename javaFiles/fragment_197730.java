@XmlRootElement(name = "parent")
public class Parent {
    private String field1;
    private String field2;
    private String field3;
    private List<Child> child;

    // Getters and setters...
}

public class Child {
    private String fieldA;
    private String fieldB;

    // Getters and setters...
}