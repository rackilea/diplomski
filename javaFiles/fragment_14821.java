@Entity
public class CustomerAgreement  {

    @ElementCollection
    @JoinTable(name="...", joinColumn = "id")
    private List<CustomerAgreementComputerAttachment> attachments;
}