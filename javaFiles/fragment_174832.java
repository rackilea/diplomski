@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="ASSIGNMENT_TYPE_ID")
@Table(name="assignment")
public abstract class Assignment {
    ...
    @ManyToOne
    @JoinColumn(name = "ASSIGNMENT_TYPE_ID", insertable = false, updatable = false)
    private AssignmentType assignmentType;
}