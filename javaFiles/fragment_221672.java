// SOAP Body
SOAPBody soapBody = envelope.getBody();
SOAPElement GetNGPList =
       soapBody.addChildElement("GetNGPList", "", "http://www.sigvalue.com/acc");

SOAPElement UserData = GetNGPList.addChildElement("UserData");
...