@Entity
@Table(name = "childs")
public class Container {

    @Id
    //optional your id strategy
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "xyz")
    Long id;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="childs", joinColumns=@JoinColumn(name="id"))
    private Set<Child> childs  = new HashSet<>();
}

@Embeddable
public class Child {

    String name;
    String value;
    String param;
}