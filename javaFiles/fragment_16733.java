public class Order
{
    @EmbeddedId
    private OrderId id;

    @ManyToOne
    @JoinColumn(insertable=false, updatable=false)
    private Client client;

    @Column(insertable=false, updatable=false)
    private Long orderSequence;  // unique within a client

    @OneToMany(targetEntity = Orderline.class, fetch = FetchType.LAZY)
    private List<Orderline> orderlines;
}

@Embeddable
public class OrderId {
    Long clientId;
    Long orderSequence;
}