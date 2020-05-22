public bool handleFault(SOAPMessageContext context)
{
    try {
        if (context.getMessage().getSOAPBody().hasFault()) {
            SOAPFault fa = context.getMessage().getSOAPBody().getFault();
            System.err.println(fa.getFaultCode());
            System.err.println(fa.getFaultString());
        }
        return true;
    } catch (SOAPException ex) {
        System.err.println("Fault parsing Exception:" + ex.getMessage());
        return true;
    }
    return false;
}