@WebServiceProvider
@ServiceMode(Mode.MESSAGE)
public class SOAPServer implements Provider<SOAPMessage> {

    public SOAPMessage invoke(SOAPMessage request) {
        ... process request and create response 
        return response;
    }

    public static void main(String[] args) throws Exception {
        Endpoint.publish("http://localhost:1111/test",  new SOAPServer());
    }
}