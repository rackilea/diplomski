@WebService(name = "ICalculator", targetNamespace = "http://Example.org")
public interface ICalculator {
   ….
    @WebMethod(operationName = "Add", action = "http://Example.org/ICalculator/Add")
    @WebResult(name = "result", targetNamespace = "http://Example.org")
    @RequestWrapper(localName = "Add", targetNamespace = "http://Example.org", className = "org.example.Add")
    @ResponseWrapper(localName = "AddResponse", targetNamespace = "http://Example.org", className = "org.example.AddResponse")
    public Integer add(
        @WebParam(name = "a", targetNamespace = "http://Example.org")
        Integer a,
        @WebParam(name = "b", targetNamespace = "http://Example.org")
        Integer b);

   ….
}