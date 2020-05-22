@Entity(name = "ContractAttachment") // note the same name of table
@IdClass(ContractAttachmentId.class)
public class ContractAttachment implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name="contract_id") // same mappings for columns
    private Contract contract;

    @Id
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="attachment_id") // same mappings for columns
    private Attachment attachment;

    // you will also have to override equals and hashcode methods here

}