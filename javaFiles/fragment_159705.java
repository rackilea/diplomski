public class VersionNumberValidator implements SOAPHandler<SOAPMessageContext> {
@SuppressWarnings("unused")
@Override
public boolean handleMessage(SOAPMessageContext ctx) {
    // Is this an inbound message, i.e., a request?
    Boolean response_p = (Boolean) ctx
            .get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

    // Manipulate the SOAP only if it's incoming.
    if (!response_p) {
        try {
            SOAPMessage msg = ctx.getMessage();
            SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
            SOAPHeader hdr = env.getHeader();

            // Ensure that the SOAP message has a header.
            if (hdr == null) {
                generateSOAPFault(msg, "No message header.");
                return true;
            }

            Iterator mustUnderstandHeaders = msg.getSOAPHeader()
                    .examineMustUnderstandHeaderElements(
                            "http://schemas.xmlsoap.org/soap/actor/next");
            String value = null;
            while (mustUnderstandHeaders.hasNext()) {
                Node next = (Node) mustUnderstandHeaders.next();
                System.out.println("mustUnderstandHeaders name:"
                        + next.getValue());
                if (next.getNodeName().equalsIgnoreCase("versionnumber"))
                    value = next.getValue();
                if (value != null && !value.equalsIgnoreCase("v1.0")) {
                    generateSOAPFault(msg, "Version Number Mismatch");
                }
            }

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

@Override
public boolean handleFault(SOAPMessageContext ctx) {

    return true; // do continue down the chain
}

// For now, no-ops.
@Override
public Set<QName> getHeaders() {

    Set<QName> headers = new HashSet<QName>();
    QName qName = new QName("http://ticket.example.com/", "versionnumber");
    headers.add(qName);

    return headers;
}

@Override
public void close(MessageContext messageContext) {
}

private void generateSOAPFault(SOAPMessage msg, String reason) {
    try {
        SOAPBody body = msg.getSOAPBody();
        SOAPFault fault = body.addFault();
        QName fault_name = new QName(
                SOAPConstants.URI_NS_SOAP_1_2_ENVELOPE, "UltimateReceiver");
        fault.setFaultCode(fault_name);
        fault.setFaultRole("http://ticket.example.com/versionNumber_validator");
        fault.addFaultReasonText(reason, Locale.US);
    } catch (SOAPException e) {
    }
}