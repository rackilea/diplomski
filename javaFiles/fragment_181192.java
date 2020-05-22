@Entity
public class Document {

    @Id
    @GeneratedValue
    private long id;

    @ManyToMany
    private Set<Status> statuses;
}