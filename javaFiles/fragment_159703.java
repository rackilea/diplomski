public class VersionNumberHandler implements SOAPHandler<SOAPMessageContext> {
private static final String LoggerName = "ClientSideLogger";
private Logger logger;
private final boolean log_p = true; // set to false to turn off

public VersionNumberHandler() {
    logger = Logger.getLogger(LoggerName);
}

public boolean handleMessage(SOAPMessageContext ctx) {
    if (log_p)
        logger.info("handleMessage");

    // Is this an outbound message, i.e., a request?
    Boolean request_p = (Boolean) ctx
            .get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

    // Manipulate the SOAP only if it's a request
    if (request_p) {
        // Get the Version Number from some property file ,
        // to place in the message header.
        String versionNumber = "v1.0";

        try {
            SOAPMessage msg = ctx.getMessage();
            SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
            SOAPHeader hdr = env.getHeader();
            // Ensure that the SOAP message has a header.
            if (hdr == null)
                hdr = env.addHeader();

            QName qname = new QName("http://ticket.example.com/",
                    "versionnumber");
            SOAPHeaderElement helem = hdr.addHeaderElement(qname);

            // In SOAP 1.2, setting the actor is equivalent to
            // setting the role.
            helem.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
            helem.setMustUnderstand(true);
            helem.addTextNode(versionNumber);
            msg.saveChanges();

            // For tracking, write to standard output.
            msg.writeTo(System.out);
        } catch (SOAPException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    return true; // continue down the chain
}

public boolean handleFault(SOAPMessageContext ctx) {
    if (log_p)
        logger.info("handleFault");
    try {
        ctx.getMessage().writeTo(System.out);
    } catch (SOAPException e) {
        System.err.println(e);
    } catch (IOException e) {
        System.err.println(e);
    }
    return true;
}

public Set<QName> getHeaders() {
    if (log_p)
        logger.info("getHeaders");
    return null;
}

public void close(MessageContext messageContext) {
    if (log_p)
        logger.info("close");
}