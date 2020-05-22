@MappedSuperclass
public abstract class GenericEntity {
    private Integer id;
    ...

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
}


@Entity
@Table(name = "POJO_ONE")
@SequenceGenerator(name = "HB_SEQ_POJO_ONE", sequenceName = "SEQ_POJO_ONE", allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name = "ID"))
public class PojoOne extends GenericEntity {
    // we should not define id here again
    ...

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HB_SEQ_POJO_ONE")
    public Integer getId() {return id;}
}