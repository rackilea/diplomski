@Entity
@DiscriminatorValue("W")
@Table(name="written_assignment")
public class WrittenAssignment extends Assignment {
    ...
}