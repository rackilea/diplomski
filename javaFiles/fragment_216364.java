@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CardUpdateResponse", namespace="http://www.samople.com/Prepaid")
public static class CardUpdateResponseWrapper {

    @XmlElement(name="CARDUPDATE_RET")
    private FVCardUpdateResponse response;

    // Getter and setter for response

    public static class FVCardUpdateResponse {

        @XmlElement(name = "AccountNumber")
        private String AccountNumber;

        @XmlElement(name = "ResCode")
        private String ResCode;

        @XmlElement(name = "ResErrorCode")
        private String ResErrorCode;

        @XmlElement(name = "ResErrorMsg")
        private String ResErrorMsg;

        // Getters and setters
    }

}