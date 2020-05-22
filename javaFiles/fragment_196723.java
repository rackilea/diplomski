@Entity
public class Invoice {
  @Id
  private long id;

  @OneToMany(mappedBy="invoice", cascade = CascadeType.ALL)
  private List<InvoiceDetail> details;
}

@Entity
public class InvoiceDetails {
  @Id
  private long id;

  @ManyToOne
  @JoinColumn(name="invoice_id")
  private Invoice invoice;
}