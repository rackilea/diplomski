@Entity
@Audited
@Table(name = "Receipt")
public class ReceiptModel {
  @Valid
  @ManyToOne
  @JoinColumn(name = "personId")
  @Audited(targetAuditMode = NOT_AUDITED)
  private PersonModel person;
  ...
}

@Entity
@Table(name = "Person")
public class PersonModel {
}