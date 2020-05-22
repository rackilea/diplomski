@Entity
@Table(name = "invoice")
public class Invoice {
  @Id
  @Column(name = "invoiceid")
  private String id;

  @OneToOne
  @PrimaryKeyJoinColumn
  private InvoiceView invoiceView;
}

@Entity
@Table(name = "invoice_view")
public class InvoiceView {
  @Id
  @Column(name = "invoiceid")
  private String id;
}