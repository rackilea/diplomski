package hello;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class Hello {
    @WebMethod
    public String sayHello(String name) {
        return "Hello, " + name + ".";
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/WS/Hello", new Hello());
    }
}