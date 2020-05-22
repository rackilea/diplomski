String endpoint =
            "http://localhost:8080/eCWServices/StructSpeech/StructSpeech";
    Service service = new Service();
    Call call = (Call) service.createCall();
    call.setTargetEndpointAddress(new java.net.URL(endpoint));
    call.setOperationName(new QName("http://ejb.ecw.com/", "parseNotes"));
    call.addParameter("notes", org.apache.axis.Constants.XSD_STRING, ParameterMode.IN);
    call.addParameter("apuId", org.apache.axis.Constants.XSD_STRING, ParameterMode.IN);
    call.addParameter("providerId", org.apache.axis.Constants.XSD_STRING, ParameterMode.IN);
    call.setReturnType(XMLType.SOAP_MAP);
    HashMap  ret = (HashMap) call.invoke(new Object[]{"","",""});
    System.out.println("Sent 'Hello!', got '" + ret + "'");