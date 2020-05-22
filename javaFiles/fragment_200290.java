@XmlRootElement(name = "LoginResult", namespace = "http://test.org/ADMail_Service")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginResult {
    @XmlElement(name = "ErrorMessage", namespace = "http://test.org/ADMail_Service")
    private String errorMessage;
    @XmlElement(name = "Status", namespace = "http://test.org/ADMail_Service")
    private String status;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


public static void main(String[] args) {
        try {
            XMLInputFactory xif = XMLInputFactory.newFactory();
            XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("input.xml"));
            xsr.nextTag(); // Advance to Envelope tag

            xsr.nextTag(); // Advance to Body tag
            xsr.nextTag();
            xsr.nextTag();


            JAXBContext jc = JAXBContext.newInstance(LoginResult.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<LoginResult> je = unmarshaller.unmarshal(xsr, LoginResult.class);

            System.out.println(je.getName());
            System.out.println(je.getValue());
            System.out.println(je.getValue().getErrorMessage());
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }