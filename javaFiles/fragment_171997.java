@Embeddable
public class DetailOrderId implements Serializable{

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "BOOK_ID", insertable = false, updatable = false, nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID", insertable = false, updatable = false, nullable = false)
    private BookOrders bookorders;