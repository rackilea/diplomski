@Entity
@Table(name="ORDERS")

@IdClass(OrderPK.class)
public class Order extends GeneralTableInformation implements Model<Integer>{

    @Id
    private Integer orderId;

    @Id
    private Integer memberId;
}

public class OrderPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name="ORDERS_ID", nullable=false)
    private Integer orderId;

    @Column(name="MEMBER_ID", nullable=false)
    private Integer memberId;
}