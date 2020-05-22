package hello;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWorld{
    @WebMethod
    public String method(String name)
    {

        return "hello " +name;
    }
}