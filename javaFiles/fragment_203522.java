Iterator it = soapResponse.getSOAPBody().getChildElements(
        envelope.createName(operation + "Response", null, "http://server.splat/")
    );

    soapBodyElem = (SOAPElement) it.next();
    it = soapBodyElem.getChildElements(
        envelope.createName("return")
    );

    while (it.hasNext()) {

        String value = ((SOAPElement) it.next()).getTextContent();
        System.out.println(value);
    }