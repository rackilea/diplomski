@Entity
@Table(name="ORDERS")
@IdClass(OrderPK.class)
public class Order extends GeneralTableInformation implements Model<Integer>{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ORDERS_ID", nullable=false)
    private Integer orderId;

    @Id
    @Column(name="MEMBER_ID", nullable=false)
    private Integer memberId;