public class InInt extends AbstractSoapInterceptor{

private SAAJInInterceptor saajInterceptor = new SAAJInInterceptor();
public InInt(String p) {
    super(p);
    // TODO Auto-generated constructor stub
}
public InInt() {
      super(Phase.PRE_PROTOCOL);
      getAfter().add(SAAJInInterceptor.class.getName());
   }

@Override
public void handleMessage(SoapMessage message) throws Fault {
    SOAPMessage doc = message.getContent(SOAPMessage.class);
    if (doc == null) {
         saajInterceptor.handleMessage(message);
         doc = message.getContent(SOAPMessage.class);
      }
      SOAPHeader header = null;
      try {
         header = doc.getSOAPHeader();
      } catch (SOAPException e) {
        // exception handling logic...
      }

      //header handling logic here...

      SOAPBody body = null;
      try {
          body = doc.getSOAPBody();
      } catch (SOAPException e){
          //exception handling logic...
      }
      //body handling logic here...
}