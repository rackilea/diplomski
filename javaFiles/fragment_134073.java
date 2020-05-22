public class LoggingOutPayloadInterceptor extends AbstractSoapInterceptor {

public static final String OUT_PAYLOAD_KEY = "use.your.package.name.OUT_PAYLOAD_KEY";

public LoggingOutPayloadInterceptor() {
    super(Phase.POST_PROTOCOL);
}

@Override
public void handleMessage(SoapMessage soapMessage) throws Fault {

    Document document = soapMessage.getContent(SOAPMessage.class).getSOAPPart();
    StringWriter stringWriter = new StringWriter();
    try {
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult(stringWriter));
    } catch (TransformerException e) {
        e.printStackTrace();
    }

    soapMessage.getExchange().put(OUT_PAYLOAD_KEY, stringWriter.toString());
}