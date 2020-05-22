public class Order
{
    @Id
    private Long id;

    @OneToMany(targetEntity = Orderline.class, fetch = FetchType.LAZY)
    private List<Orderline> orderlines;

    private Client client;

    private Long orderSequence;  // unique within a client
}

public class Orderline
{
    @Id
    private Long id;   // unique ID of order line

    @ManyToOne(mappedBy = 'orderlines')
    private Order order;

    // not necessary, as you can access through orderLine.order.client
    // private Client client;
}