@Entity
public class Employee implements Serializable {
    private @Id Long id;

    @OneToMany(mappedBy="employee")
    private List<EmployeeSkillSet> skillSets;
}

@Entity
public class SkillSet implements Serializable {
    private @Id Long id;
}

@Entity
public class EmployeeSkillSet implements Serializable {
    private @Id Long id;
    private @ManyToOne Employee employee;
    private @ManyToOne SkillSet skillSet;
    private @Basic int numberOfYears;
}