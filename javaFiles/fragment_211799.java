@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_id")
    private int id;

    @Column(name = "training_name")
    private String trainingName;

    @Column(name = "date")
    private Date date;

    @OneToMany(mappedBy = "training")
    private Set<Exercise> exercises = new HashSet<>();


@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private int id;

    @Column(name = "exercise_name")
    private String name;

    @Column(name = "weight")
    private double weight;

    @Column(name = "series")
    private int series;

    @Column(name = "training_id")
    private int trainingId;

    @ManyToOne
    @JsonIgnoreProperties("exercises")
    private Training training;