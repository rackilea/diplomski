public class LoggingInPayloadInterceptor extends AbstractSoapInterceptor {

public static final String IN_PAYLOAD_KEY = "use.your.package.name.IN_PAYLOAD";

public LoggingInPayloadInterceptor() {
    super(Phase.POST_PROTOCOL);
    addAfter(SAAJInInterceptor.class.getName());
}

@Override
public void handleMessage(SoapMessage message) throws Fault {
    Document document = message.getContent(SOAPMessage.class).getSOAPPart();
    StringWriter stringWriter = new StringWriter();
    try {
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult(stringWriter));
    } catch (TransformerException e) {
        e.printStackTrace();
    }

    message.put(IN_PAYLOAD_KEY, stringWriter.toString());
    message.put(LoggingOutPayloadInterceptor.OUT_PAYLOAD_KEY, message.getExchange().get(LoggingOutPayloadInterceptor.OUT_PAYLOAD_KEY));
}