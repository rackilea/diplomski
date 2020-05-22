@Entity @IdClass(EmployeeSkillSet.Key.class)
public class EmployeeSkillSet implements Serializable {

    private @Id @ManyToOne Employee employee;
    private @Id @ManyToOne SkillSet skillSet;
    private @Basic int numberOfYears;

    public static class Key implements Serializable {
        private Long employee; // plus getter+setter
        private Long skillSet; // plus getter+setter
        // plus hashCode, equals
    }
}