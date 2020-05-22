URL wsdlLocation = new URL("your_wsdl_target");
QName apiName = new QName("your_service_target", "your_service_name");
your_service_name api = new your_service_name(wsdlLocation, apiName);
api.addPort(your_service_name, SOAPBinding.SOAP12HTTP_BINDING, "your_service_target/name");

QName port_name = new QName("your_service_target", "port_name");
Dispatch<SOAPMessage> disp = api.createDispatch(port_name, SOAPMessage.class, Service.Mode.MESSAGE);            

String xml = "Your SOAP MESSAGE";

MessageFactory mf = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
SOAPMessage request = mf.createMessage();
SOAPPart part = request.getSOAPPart();
StreamSource source = new StreamSource(new StringReader(xml));
part.setContent(source);
request.saveChanges();

SOAPMessage response = disp.invoke(request);

StringWriter sw = new StringWriter();
TransformerFactory.newInstance().newTransformer().transform(new DOMSource(response.getSOAPPart()), new StreamResult(sw));
org.json.JSONObject xmlJSONObj = XML.toJSONObject(sw.toString());
return xmlJSONObj.toString(2);