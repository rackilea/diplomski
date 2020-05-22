@WebServiceRef(wsdlLocation="http://localhost:8080/
    helloservice/hello?wsdl")
static HelloService service;
...  

Hello port = service.getHelloPort();

....
String response = port.sayHello(name);