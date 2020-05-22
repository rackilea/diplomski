@Entity(name = "Employee")
public static class Employee {

    @EmbeddedId
    private EmployeeId id;

    private String name;

    @OneToOne(mappedBy = "employee")
    private EmployeeDetails details;

    public EmployeeId getId() {
        return id;
    }

    public void setId(EmployeeId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeDetails getDetails() {
        return details;
    }

    public void setDetails(EmployeeDetails details) {
        this.details = details;
    }
}