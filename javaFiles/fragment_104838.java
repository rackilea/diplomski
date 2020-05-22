@Entity
@EntityListeners(ABListener.class)
@Table(name = "a_b", uniqueConstraints =
@UniqueConstraint(name = "uk_rel_a_b", columnNames = {"a_id", "c_id"}))
public class AB extends BaseEntity<Long> {

    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "a_id")
    private A a;

    @ManyToOne(optional = false)
    @JoinColumn(name = "b_id")
    private B b;

    @ManyToOne(optional = false)
    @JoinColumn(name = "c_id")
    private C c;

    public AB(A a, B b) {
        this.a = a;
        this.b = b;
    }
    /* rest of the class */
}