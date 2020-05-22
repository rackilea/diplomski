@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class XmlTest {
    private ErrorCode errorCode;
    public XmlTest() {
    }
    public XmlTest(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlTest.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(new XmlTest(ErrorCode.EMAIL_IN_USE), System.out);
    }
}