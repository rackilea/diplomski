public class MyWsClient extends WebServiceGatewaySupport {
 //if you need some Dao, Services, just @Autowired here.

    public MyWsClient(WebServiceMessageFactory messageFactory) {
        super(messageFactory);
    }

    // here is the operation defined in your wsdl
    public Object someOperation(Object parameter){

      //instantiate the xmlbeans generated class, infact, the instance would be the document (marshaled) you are gonna send to the WS

      SomePojo requestDoc = SomePojo.Factory.newInstance(); // the factory and other methods are prepared by xmlbeans
      ResponsePojo responseDoc = (ResponsePojo)getWebServiceTemplate().marshalSendAndReceive(requestDoc); // here invoking the WS


//then you can get the returned object from the responseDoc.

   }