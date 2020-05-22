@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ExerciseLog<T extends Exercise> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @ManyToOne(targetEntity=Exercise.class)
    private T exercise;
}