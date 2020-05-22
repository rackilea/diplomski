@XmlRootElement(name = "whatever")
public class Whatever extends XmlSuperClass {
    @XmlElement(required = true)
    protected String responseCode;    // shadowing
    public void setResponseCode(String...) //overriding
}