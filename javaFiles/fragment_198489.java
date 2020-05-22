@Entity
@Table(name = "TABLE_B")
public class B implements Serializable {

    @Id
    @Column(name = "INT_ID")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer intId;

    @Id
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "A_STR_FK", referencedColumnName = "STR_ID"),
        @JoinColumn(name = "A_INT_FK", referencedColumnName = "INT_ID")
    })
    private A a;

    void setA(A a) {
        this.a = a;
    }
}