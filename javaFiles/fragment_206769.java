public class Organisation {
    @OneToMany(mappedBy="employeeOf")
    private List<Employee> employees;
    @OneToMany(mappedBy="leaderOf")
    private List<Employee> leaders;
}

public class Employee {
    @ManyToOne
    @JoinColumn("organisationAsEmployee_id")
    private Organisation employeeOf;
    @ManyToOne
    @JoinColumn("organisationAsLeader_id")
    private Organisation leaderOf;
}