@XmlType
public class Office {

    @XmlAttribute
    String name;

    @XmlElementWrapper
    @XmlElement(name="employee")
    @XmlJavaTypeAdapter(EmployeeAdapter.class) // (un)wraps Employee
    List<Employee> employees;
}

@XmlType
public class EmployeeRef {

    @XmlIDREF
    @XmlAttribute(name="ref")
    Employee employee;

    public EmployeeRef() {
    }

    public EmployeeRef(Employee employee) {
        this.employee = employee;
    }
}

public class EmployeeAdapter extends XmlAdapter<EmployeeRef, Employee> {

    @Override
    public EmployeeRef marshal(Employee employee) throws Exception {
        return new EmployeeRef(employee);
    }

    @Override
    public Employee unmarshal(EmployeeRef ref) throws Exception {
        return ref.employee;
    }
}