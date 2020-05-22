@MappedSuperclass
public abstract class AbstractOrder {
    @Id
    @GeneratedValue
    private Long idOrder;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="datum")
    private Date date = new Date();

    // This abstract method will be implemented by sub-classes
    public abstract List<IOrderLine> getOrderLines();
}