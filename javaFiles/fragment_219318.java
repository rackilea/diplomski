@Entity
public class Employee {
    private String firstName;
    private String lastName;

    @Column(name = "EMP_NAME") // Due to legacy database schema
    public String getName() {
        return fisrtName + " " + lastName;
    }

    public void setName(String name) {
        ...
    }

    ... Getters and setters for firstName and lastName with @Transient ...
}