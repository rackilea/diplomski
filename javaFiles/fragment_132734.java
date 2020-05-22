@XmlTransient                     // to prevent that the shadowed responseCode be marshalled
public class XmlSuperClass {
    private String responseCode;         // this will be shadowed
    public String getResponseCode() {    // this will be overridden
        return responseCode;
    }
    public void setResponseCode(String value) { //overridden too
        this.responseCode = value;
    }
}