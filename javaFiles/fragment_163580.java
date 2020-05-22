@Entity
public class Invoice {
    @Id
    private int invoiceId;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "compositeId.invoiceId")
    private Delivery deliveryId;
}