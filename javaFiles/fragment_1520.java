@Entity
@Table(name = "craftsman")
public class Craftsman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "craftman_skill", joinColumns = @JoinColumn(name = "craftman_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id"))
    private List<Skill> skillList;
}