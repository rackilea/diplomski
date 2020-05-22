@Entity
public class User {
    @Id
    private String username;
    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "skillOwners")
    private List<Skill> skillsList = new LinkedList<Skill>();
}