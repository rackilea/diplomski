public interface EntityId<T extends Serializable> extends Serializable {

    public T getId();

    public void setId(T id);

}

@Entity
@Table(name="categoria")
public class Category implements EntityId<Integer> {

    private static final long serialVersionUID = -870288485902136248L;

    @Id
    @Column(name="cat_id")
    @SequenceGenerator(name="cat_id_gen", sequenceName="categoria_cat_id_seq", allocationSize=1)
    @GeneratedValue(generator="cat_id_gen", strategy=GenerationType.SEQUENCE)
    private Integer id;

    //others attributes here...

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

}