@Entity
@Table(name = "variable")
@XmlRootElement
public class Variable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    // ...

    @Column(nullable = false)
    private boolean core;
}