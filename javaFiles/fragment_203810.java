@Entity
@Table(name = "<name in db>")
public class User {

    @Id
    private Integer userId;

    @Column(name = "<column name in db>")
    private String firstName;

    @Column(name = "<column name in db>")
    private String lastName;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Answer> answers;

    /* getters and setters */
}