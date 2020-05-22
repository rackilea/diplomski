@MappedSuperclass
public abstract class BaseEntity<T extends BaseEntity> {
    private Integer id;
    private List<T> children;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany(cascade=CascadeType.ALL)
    public List<T> getChildren() {
        return children;
    }
    public void setChildren(List<T> children) {
        this.children = children;
    }
}

@Entity
public class ConcreteEntity1 extends BaseEntity<ConcreteEntity2> {
    private String value;

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
@Entity
public class ConcreteEntity2 extends BaseEntity<ConcreteEntity2> {
    private String foo;

    public String getFoo() {
        return foo;
    }
    public void setFoo(String foo) {
        this.foo = foo;
    }
}