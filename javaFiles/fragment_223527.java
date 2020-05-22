/*
     * soapXMLtoEndpoint sends the soapXMLFileLocation to the endpointURL
     */
    public void soapXMLtoEndpoint(String endpointURL, String soapXMLFileLocation) throws SOAPException {
        SOAPConnection connection = SOAPConnectionFactory.newInstance().createConnection();
        SOAPMessage response = connection.call(xmlStringToSOAPMessage(soapXMLFileLocation), endpointURL);
        connection.close();
        SOAPBody responseBody = response.getSOAPBody();
        SOAPBodyElement responseElement = (SOAPBodyElement) responseBody.getChildElements().next();
        SOAPElement returnElement = (SOAPElement) responseElement.getChildElements().next();
        if (responseBody.getFault() != null) {
            System.out.println("fault != null");
            System.out.println(returnElement.getValue() + " " + responseBody.getFault().getFaultString());
        } else {
            serverResponse = returnElement.getValue();
            System.out.println(serverResponse);
            System.out.println("\nfault == null, got the response properly.\n");
        }
    }