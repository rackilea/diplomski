// Create a new SOAP 1.2 message from the message factory and obtain the SOAP body
MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
SOAPMessage message = factory.createMessage();
SOAPBody soapBody = message.getSOAPPart().getEnvelope().getBody();

// get the fault
SOAPFault fault =  soapBody.addFault();

// since this is an error generated from the business application
// where SOAPValue is the standard value code "Sender|Reciever...etc"
QName faultName = new QName(SOAPConstants.URI_NS_SOAP_1_2_ENVELOPE, SOAPValue);
fault.setFaultCode(faultName);

// set the fault reason text
// where languageLocale is the passed language local, the Locale object can be used
fault.addFaultReasonText(errorMessage, languageLocale);

// generate the detail
Detail detail = fault.addDetail();

// add the error code entry
QName customCodeEntryName = new QName("http://www.example.com/", "customCode", "ns1");
DetailEntry customCodeEntry = detail.addDetailEntry(customCodeEntryName);
customCodeEntry.addTextNode("this is custom 123 code");

// throw the exception that shall generate the SOAP fault response XML message
throw new SOAPFaultException(fault);