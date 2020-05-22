@Entity
@Table(name="order")
public class Order implements Serializable {
    [...]
    @OneToMany(targetEntity = OrderDetail.class, cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
    private List <OrderDetail> orderDetail;
    [...]
}