String endpointUrl = ...;           
QName serviceName = new QName("http://example.org/wssample/echo/", "EchoService");
QName portName = new QName("http://example.org/wssample/echo/", "EchoServicePort");

/** Create a service and add at least one port to it. **/ 
Service service = Service.create(serviceName);
service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING, endpointUrl);

/** Create a Dispatch instance from a service.**/ 
Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, 
SOAPMessage.class, Service.Mode.MESSAGE);

/** Create SOAPMessage request. **/
// compose a request message
MessageFactory mf = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);

// Create a message.  This example works with the SOAPPART.
SOAPMessage request = mf.createMessage();
SOAPPart part = request.getSOAPPart();

// Obtain the SOAPEnvelope and header and body elements.
SOAPEnvelope env = part.getEnvelope();
SOAPHeader header = env.getHeader();
SOAPBody body = env.getBody();

// Construct the message payload.
SOAPElement operation = body.addChildElement("invoke", "ns1",
"http://com/ibm/was/wssample/echo/");
SOAPElement value = operation.addChildElement("arg0");
value.addTextNode("ping");
request.saveChanges();

/** Invoke the service endpoint. **/
SOAPMessage response = dispatch.invoke(request);