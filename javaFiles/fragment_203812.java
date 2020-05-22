@Entity
@Table(name = "<name in db>")
public class Step {

    @Id
    private Integer stepId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Answer answer;

    @Column(name = "<column name in db>")
    private Object image;

    @Column(name = "<column name in db>")
    private String text;

    /* getters and setters */
}