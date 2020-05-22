MyServiceLocator wsLocator = new MyServiceLocator();
MyServiceSoap ws = wsLocator.getMyServiceSoap(new URL("http://localhost/MyService.asmx"));

//add SOAP header for authentication
SOAPHeaderElement authentication = new SOAPHeaderElement("http://mc1.com.br/","Authentication");
SOAPHeaderElement user = new SOAPHeaderElement("http://mc1.com.br/","User", "string");
SOAPHeaderElement password = new SOAPHeaderElement("http://mc1.com.br/","Password", "string");
authentication.addChild(user);
authentication.addChild(password);
((Stub)ws).setHeader(authentication);

//now you can use ws to invoke web services...