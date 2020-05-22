@Embeddable
public class CompositeId implements Serializable{
    @Column(unique = true)
    private int deliveryId;
    @MapsId
    @OneToOne
    @JoinColumn(name = "invoiceId",unique = true)
    private Invoice invoiceId;
    //hashcode and equals methods
}