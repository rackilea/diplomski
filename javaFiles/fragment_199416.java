@Entity
@Data
public class InvoiceItem {
    @ManyToOne 
    @EqualsAndHashCode.Exclude @ToString.Exclude
    @JoinColumn(name="invoice_id", nullable = false)
    private Invoice invoice;