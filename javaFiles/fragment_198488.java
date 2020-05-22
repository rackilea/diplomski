@Entity
@Table(name = "TABLE_A")
public class A implements Serializable {

    @Id
    @Column(name = "STR_ID")
    private String strId;

    @Id
    @Column(name = "INT_ID")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer intId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "a")
    private List<B> bs;

    public A(String strId) {
        this.strId = strId;
    }

    public void addB(B b) {
        if (bs == null) {
            bs = new ArrayList<B>();
        }
        b.setA(this);
        bs.add(b);
    }
}