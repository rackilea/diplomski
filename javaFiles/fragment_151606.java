public class LogMessageHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(SOAPMessageContext context){
        try {
            if ((Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY)) {
                SOAPMessage message = context.getMessage();
                SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.getHeader();
                if (null == header)
                    header = envelope.addHeader();

                QName credential = new QName("http://soap.header.test.com", "Credential");
                SOAPHeaderElement headerElement = header.addHeaderElement(credential);
                QName username = new QName("username");
                headerElement.addAttribute(username, "ashok");
                QName password = new QName("password");
                headerElement.addAttribute(password, "123");

                message.writeTo(System.out);
                return true;
            }

        } catch (Exception e) {
            System.err.println("An error in handler occurs.");
        }
        return false;
    }