WebService(serviceName = "Hello", targetNamespace = "http://127.0.0.1/hello")
@SOAPBinding(style = Style.RPC)

public class HelloService {

    public static final String ROUTE = "/hello";
    public static final String OWLS_FILE = Bootstrap.OWLS_DIR + "/hello.owl";
    public static final String WSDL_FILE = "http://127.0.0.1/hello?wsdl";

    /**
     * This is a sample web service operation
     *
     * @param name
     * @return
     */
    @WebMethod(operationName = "hello")
    @WebResult(name="greeting")
    public String hello(@WebParam(name = "name") String name) {
        return "Hello " + name;
    }
}