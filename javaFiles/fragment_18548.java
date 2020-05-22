public void marshalWithSoapActionHeader(MyObject o) {

    webServiceTemplate.marshalSendAndReceive(o, new WebServiceMessageCallback() {

        public void doWithMessage(WebServiceMessage message) {
            SaajSoapMessage saajSoapMessage = (SaajSoapMessage) message;
            SOAPMessage soapMessage = saajSoapMessage.getSaajMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            SOAPHeader header = soapMessage.getSOAPHeader(); 
            header.detachNode();
        }
    });
}