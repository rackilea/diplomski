private static final String cNODE_USRTOKEN = "UsernameToken";
private static final String cNODE_USERNAME = "Username";
private static final String cNODE_PASSWORD = "Password";
private String iUsername;
private String iPassword;
private static final Logger cTRACE = Logger.getLogger(UsernameTokenHandler.class.getName());

public Element getToken() 
{


    Element assertion = null;
    SOAPElement soapElement = null;

    try 
    {

        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
        SOAPPart sOAPPart = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = sOAPPart.getEnvelope();
        SOAPHeader header = envelope.getHeader(); 

        if (header==null) 
        {
            // no header yet, create one
            header = envelope.addHeader();
        }
        SOAPElement security = header.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");



        Name tUserTokenElementName = envelope.createName(cNODE_USRTOKEN, "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
        SOAPElement tUserTokenElement = security.addChildElement(tUserTokenElementName);
        tUserTokenElement.removeNamespaceDeclaration("wsse");
        tUserTokenElement.addNamespaceDeclaration("wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

        // user name child
        Name tUsernameElementName = envelope.createName(cNODE_USERNAME, "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
        SOAPElement tUsernameElement = tUserTokenElement.addChildElement(tUsernameElementName);
        tUsernameElement.removeNamespaceDeclaration("wsse");
        tUsernameElement.addTextNode(iUsername);

        // password child
        Name tPasswordElementName = envelope.createName(cNODE_PASSWORD, "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
        SOAPElement tPasswordElement = tUserTokenElement.addChildElement(tPasswordElementName);
        tPasswordElement.removeNamespaceDeclaration("wsse");
        tPasswordElement.addTextNode(iPassword);
        tPasswordElement.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");

        assertion = (Element) security;

        //printAssertion(assertion);
        //MessageElement samlElement = new MessageElement(assertion);
        //SAMLHandler.setAssertion((SOAPElement) samlElement);
        //soapElement = (SOAPElement) samlElement;

    } 
    catch (Exception e) 
    {
        if (cTRACE.isLoggable(Level.SEVERE)) 
        {
            cTRACE.logp(Level.SEVERE,UsernameTokenHandler.class.getName(),"handleMessage", "Unable to add WSS credentials", e);
        }

        // stop processing
        return assertion;
    }

    // continue processing
    return assertion;
}