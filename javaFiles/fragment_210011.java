@Entity
@Table(name="orderDetail")
public class OrderDetail implements Serializable {
    [...]
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    [...]
}