try{
  java.net.URL url =new java.net.URL("http://host.com/HelloBeanService/HelloBean?wsdl");
  javax.xml.namespace.QName qName =new javax.xml.namespace.QName("http://sap.com/tutorial/helloworld/", "HelloBeanService");
  HelloBeanService client=new HelloBeanService(url, qName);
  HelloBean helloService =client.getHelloBeanPort();


  // Add username and password for Basic Authentication
  Map<String, Object> reqContext = ((BindingProvider) helloService).getRequestContext();
  reqContext.put(BindingProvider.USERNAME_PROPERTY, "YOUR_USERNAME");
  reqContext.put(BindingProvider.PASSWORD_PROPERTY, "YOUR_PASSWORD");

  result= helloService.sayHello();
}
catch(Exceptione){
  result=e.toString();
}