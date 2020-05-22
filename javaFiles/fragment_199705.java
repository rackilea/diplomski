@MappedSuperclass
public abstract class AbstractModel {
    protected int id;
    protected String property1;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
         this.id = id;
    }

    @Column(name = "prop1")
    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
         this.property1 = property1;
    }
}