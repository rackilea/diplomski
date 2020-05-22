MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        // Retrieve different parts
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();

        soapEnvelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
        soapEnvelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");

        // Two ways to extract headers
        //    SOAPHeader soapHeader = soapEnvelope.getHeader();
        //    soapHeader = soapMessage.getSOAPHeader();

        // Two ways to extract body
        SOAPBody soapBody = soapEnvelope.getBody();
        soapBody = soapMessage.getSOAPBody();

        // To add some element

        SOAPElement GetParamter=soapBody.addBodyElement(new javax.xml.namespace.QName("http://examples/2001", "GetParamter"));
        GetParamter = GetParamter.addChildElement(new javax.xml.namespace.QName("request"));
        SOAPElement MonCode=GetParamter.addChildElement(new javax.xml.namespace.QName("http://newsite/mon", "MonCode"));
        MonCode.addTextNode("Latency");

        SOAPElement TimeFrom=GetParamter.addChildElement(new javax.xml.namespace.QName("http://newsite/mon", "TimeFrom"));
        TimeFrom.addTextNode("2016-10-26T11:00");

        SOAPElement TimeTo=GetParamter.addChildElement(new javax.xml.namespace.QName("http://newsite/mon", "TimeTo"));
        TimeTo.addTextNode("2016-10-26T12:00");