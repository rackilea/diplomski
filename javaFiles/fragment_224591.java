import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;


@Root(name = "ns2:requestCPResponse",strict = false)
@Namespace( prefix = "ns2", reference = "http://incomingwebchannel.hrz.jpos.org/")
public class BuyCPResponse {

    @Element(name = "return")
    private BuyResponseReturn responseReturn;

    public BuyResponseReturn getResponseReturn() {
        return responseReturn;
    }

    public void setResponseReturn(BuyResponseReturn responseReturn) {
        this.responseReturn = responseReturn;
    }
}