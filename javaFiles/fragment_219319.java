@Entity @Access(AccessType.FIELD)
public class Employee {
    @Access(AccessType.PROPERTY) @Column(name = "EMP_NAME")
    public String getName() { ... }
    ... other properties have field access ...
}