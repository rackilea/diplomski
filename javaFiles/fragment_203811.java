@Entity
@Table(name = "<name in db>")
public class Answer {

    @Id
    private Integer answerId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @OneToMany(mappedBy = "answer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Step> steps;

    /* getters and setters */
}