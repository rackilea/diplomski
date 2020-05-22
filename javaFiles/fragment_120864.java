@JacksonXmlRootElement
class Message {
    @JacksonXmlProperty(localName = "DATA_RECORD")
    private TestBean dataRecord;
}

class TestBean {
    @JacksonXmlProperty(localName = "ERROR_MESSAGE_CODE")
    private String error_message_code;
    @JacksonXmlProperty(localName = "ERROR_MESSAGE")
    private String error_message;
}