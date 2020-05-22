@Entity
@IdClass(EmployeeId.class)
public class Employee {
    @Id private String country
    @Id
    @Column(name = "EMP_ID")
    private int id;
    private String name;
    ...
}

public class EmployeeId implements Serializable {
    private String country;
    private int id;

    public EmployeeId() { }
    public EmployeeId(final String country, final int id) {
        this.country = country;
        this.id = id;
    }

    //getters for the properties

    public boolean equals(final Object other) {
    //must be implemented
    }

    public int hashCode() {
    //must be implemented
    }
}