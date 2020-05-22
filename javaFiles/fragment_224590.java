import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "S:Body" ,strict = false)
public class BuyResponseBody {

    @Element(name = "requestCPResponse")
    private BuyCPResponse cpResponse;


    public BuyCPResponse getCpResponse() {
        return cpResponse;
    }

    public void setCpResponse(BuyCPResponse cpResponse) {
        this.cpResponse = cpResponse;
    }
}