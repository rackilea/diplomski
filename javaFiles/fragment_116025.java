@Entity
public class OrgUnit{

    @OneToMany(mappedBy="orgUnit")
    private Set<Binding> bindings;

}

@Entity
public class Employee{

    @OneToMany(mappedBy="employee")
    private Set<Binding> bindings;

}

@Entity
public class Binding{

    @ManyToOne(optional = true)
    private Employee employee;

    @ManyToOne(optional=true)
    private OrgUnit orgUnit;

    @ManyToOne(optional=false)
    private WorkStation owner;

}

@Entity
public class WorkStation{

    @OneToMany(mappedBy="owner")
    private Set<Binding> bindings;

}