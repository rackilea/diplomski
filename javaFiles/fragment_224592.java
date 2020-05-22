import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@Root(name = "return",strict = false)
@Namespace( prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance")
public class BuyResponseReturn {


    @Element(name = "refNo")
    private String refNo;

    @Element(name = "responseCode")
    private String responseCode;

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;

    }

}