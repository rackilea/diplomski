public class DetailOrder implements Serializable{

    @EmbeddedId
    @AttributeOverrides({ @AttributeOverride(name = "ORDER_ID", column = @Column(name = "ORDER_ID", nullable = false)),
        @AttributeOverride(name = "BOOK_ID", column = @Column(name = "BOOK_ID", nullable = false))})
    private DetailOrderId pk = new DetailOrderId();

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "BOOK_ID", insertable = false, updatable = false, nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID", insertable = false, updatable = false, nullable = false)
    private BookOrders bookorders;  }