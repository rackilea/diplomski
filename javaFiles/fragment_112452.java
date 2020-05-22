@Entity
@Table(name="competitors")
public class Competitor {
    @Id
    @Column(name="hipchat_id", unique=true, nullable=false)
    public int hipchat_id;

    @Column(name="name")
    @Validate("required")
    private String name;

    @Column(name="score")
    private int score;

    @Column(name="goal")
    private int goal = 14000;

    @Column(name="progress")
    private int progress = score/goal;