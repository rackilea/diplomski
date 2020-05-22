@Entity
public class Entity2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "entity2")
    private Collection<Entity1Entity2> collection;

    ...
}