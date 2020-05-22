@Entity(name="person")
public class Person implements Serializable {

    @Id
    private Long id;

    @Column(unique = true)
    private final String uuid;

    // others attributes removed
}