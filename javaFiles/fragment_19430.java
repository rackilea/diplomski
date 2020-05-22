@Entity
@Table(name = "B")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCRIMINATOR", discriminatorType = DiscriminatorType.STRING, length = 1)
public abstract class B<AClass extends A> {
    private Long id;
    private AClass a;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = A.class)
    @JoinColumn(name = "A_ID")
    public AClass getA() {
        return a;
    }

    public void setA(AClass a) {
        this.a = a;
    }
}