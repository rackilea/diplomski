@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentGroup {

    @XmlElement(name = "TERM_ID", required = true)
    private double termId;

    @XmlElement(name = "NAME", required = true)
    private String termName;

}