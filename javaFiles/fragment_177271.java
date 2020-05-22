@XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public class VisaResponse {

        @XmlElement
        private int id;

        // for testing purpose. Remove once database integration is done and data is received via service and repository.
        public VisaResponse() {
            id = 3;
        }
    }