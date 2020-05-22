@XmlRootElement(name = "DATA_DS")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentTerm {

    @XmlElement(name = "G_1", required = true)
    private PaymentGroup group;

}