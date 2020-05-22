@OneToOne(optional=false)
@JoinColumn(name="EMPLOYEEID")
Employee employee;

public Employee getEmployee() {
     return employee;
}