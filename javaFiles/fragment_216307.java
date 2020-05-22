@Entity(name = "EmployeeDetails")
public static class EmployeeDetails {

    @EmbeddedId
    private EmployeeId id;

    @MapsId
    @OneToOne
    private Employee employee;

    private String details;

    public EmployeeId getId() {
        return id;
    }

    public void setId(EmployeeId id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        this.id = employee.getId();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}