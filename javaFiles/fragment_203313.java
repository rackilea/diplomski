@Entity
public class Entity1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "entity1")
    private Collection<Entity1Entity2> collection;

    ...
}