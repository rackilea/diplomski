SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
    this.soapConnection = soapConnectionFactory.createConnection();

    MessageFactory messageFactory = MessageFactory.newInstance();
    SOAPMessage soapMessage = messageFactory.createMessage();
    SOAPPart soapPart = soapMessage.getSOAPPart();

    // SOAP Envelope
    SOAPEnvelope envelope = soapPart.getEnvelope();
    envelope.addNamespaceDeclaration("ser", "http://server.splat/");

    // SOAP Body
    SOAPBody soapBody = envelope.getBody();

    SOAPElement soapBodyElem = soapBody.addChildElement(operation, "ser");
    int n = 0;
    for (Object argN : args) {

        SOAPElement soapBodyElemN = soapBodyElem.addChildElement("arg" + n++);
        soapBodyElemN.addTextNode(argN.toString());
    }

    MimeHeaders headers = soapMessage.getMimeHeaders();
    headers.addHeader("SOAPAction", "\"\"");

    soapMessage.saveChanges();

    /* Print the request message */
    debug(operation + " Request SOAP Message:\n" + traceSOAPMessage(soapMessage));

    SOAPMessage soapResponse = this.soapConnection.call(
        soapMessage, this.url
    );