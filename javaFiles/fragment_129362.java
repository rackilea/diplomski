getWebServiceTemplate().marshalSendAndReceive("https://soap.endpoint",
    requestObj, new WebServiceMessageCallback() {

                    public void doWithMessage(WebServiceMessage message) {
                        try {
                            SoapMessage soapMessage = (SoapMessage)message;
                            SoapHeader header = soapMessage.getSoapHeader();
                            StringSource headerSource = new StringSource("<Security><UsernameToken><SiteId>testlab1</SiteId>"+
"<Password>abcd1234</Password></UsernameToken></Security> ");
                            Transformer transformer = TransformerFactory.newInstance().newTransformer();
                            transformer.transform(headerSource, header.getResult());
                        } catch (Exception e) {
                            // exception handling
                        }
                    }
                });