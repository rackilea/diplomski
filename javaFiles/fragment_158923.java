void addWsSecurityHeader(org.apache.axis.client.Stub binding, String wsUser,String wsPass)throws SOAPException {

    // Create the top-level WS-Security SOAP header XML name.
    QName headerName = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security");
    SOAPHeaderElement header = new SOAPHeaderElement(headerName);
    //  no intermediate actors are involved.
    header.setActor(null);
    // not important, "wsse" is standard
    header.setPrefix("wsse");
    header.setMustUnderstand(true);

    // Add the UsernameToken element to the WS-Security header
    SOAPElement utElem = header.addChildElement("UsernameToken");
    SOAPElement userNameElem = utElem.addChildElement("Username");
    userNameElem.removeContents();
    userNameElem.setValue(wsUser);

    SOAPElement passwordElem = utElem.addChildElement("Password");
    passwordElem.setValue(wsPass);
    // Finally, attach the header to the binding.
    binding.setHeader(header);
}