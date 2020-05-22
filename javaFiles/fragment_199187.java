// Entity class with version field
@Entity
public class Ent1 implements Serializable {

    private static final long serialVersionUID = -5580880562659281420L;

    @Id
    Integer a1;

    Integer a2;

    @Version
    private Integer version;
}