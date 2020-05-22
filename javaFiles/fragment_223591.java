@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Tag {
    @Id
    private String id;
    private String name;
}