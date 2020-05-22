package com.KingAm.HelloWorld;

 import javax.jws.WebMethod;
  import javax.jws.WebResult;
  import javax.jws.WebService;
 import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
 import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.RPC, use=Use.LITERAL, parameterStyle= ParameterStyle.WRAPPED)
    public class helloWorldImpl{

@WebMethod(action="hello",operationName="helloWorld")
@WebResult(name="response1")
public String tMethod(String a, String b, String c)
{
    if(!c.equals(null))
    return "hello "+a+b+c;
    else
        return "okok";
}

//@Override
@WebMethod(action="hello2",operationName="helloWorld2")
@WebResult(name="response2")
public String tMethod2(String a, String b) {
    // TODO Auto-generated method stub
    return null;
}

  }