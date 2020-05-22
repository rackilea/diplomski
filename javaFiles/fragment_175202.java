@Entity
@Table(name="A")
public class A {

    @Id
    @Column(name = "id_A", length = 10)
    private String id;

    @Column(name = "col_A")
    private String colA;

    @OneToMany 
    @JoinColumn(name = "a_id")
    private List<B> detail;

    public void addB(B b){
        b.setId(this.id + new DecimalFormmat("0000").format(detail.size() + 1);
        detail.add(b);
    )
}