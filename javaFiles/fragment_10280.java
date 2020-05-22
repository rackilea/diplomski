@Endpoint
public class Service{

    private SaajSoapMessageFactory saajMessageFactory; // dependency inject this

    @PayloadRoot(namespace = "http://foo.com/coffee", localPart = "order")
    @ResponsePayload
    public Coffee getCoffee(@RequestPayload Order order, MessageContext context){
        DataHandler handler = new DataHandler(
            new URLDataSource(
                Service.class.getResource("coffee.jpg")));

        SaajSoapMessage message = saajMessageFactory.createWebServiceMessage();
        message.addAttachment("picture", handler);

        context.setResponse(message);

        return new Coffee("Hot Joe");
    }

    public void setSaajMessageFactory(SaajMessageFactory saajMessageFactory){
        this.saajMessageFactory = saajMessageFactory;
    }

    public SaajMessageFactory getSaajMessageFactory(){
        return saajMessageFactory;
    }

}