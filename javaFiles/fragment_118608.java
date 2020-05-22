public class webServiceClient extends WebServiceGatewaySupport {
public Response callsoap(Request request) {
    SoapCommand sfc = new SoapCommand(getWebServiceTemplate(), request, 
            soapRequestHeaderModifier, configuration);
    return  sfc.execute();
}

class SoapCommand extends HystrixCommand<Response>{
    public SoapCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("example"));
    }
    @Override
    protected Response run() {
        return (Response) webServiceTemplate.marshalSendAndReceive(configuration.getUri(), 
                request, soapRequestHeaderModifier);
    }
    //fallback method goes here
}