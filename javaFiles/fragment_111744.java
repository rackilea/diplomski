@Entity
public class Procurement implements Serializable {

    /**
     * The composite primary key of the underlying table is defined in the
     * {@link Procurement_ID} class.
     */
    @EmbeddedId
    private Procurement_ID procid;