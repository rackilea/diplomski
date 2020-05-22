@XmlRootElement(name = "payment", namespace="http://www.elastic-payments.com/schema/payment")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class AuthorizeRequest {

        @XmlElement(name = "merchant-account-id")
        public String merchantAccountId;
        ..........

    }