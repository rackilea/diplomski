WebServiceTemplate template = new WebServiceTemplate(messageFactory);
 Result result = new DOMResult();
 template.sendSourceAndReceiveToResult(
     new StringSource("<content xmlns=\"http://tempuri.org\"/>"),
     new SoapActionCallback("http://tempuri.org/SOAPAction"),
     result);