@WebServiceClient(name = "FooService", 
                  wsdlLocation = "classpath:wsdl/FooService.wsdl",
                  targetNamespace = "http://org/example/foo") 
public class Foo_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://org/example/foo", "Foo");
    public final static QName FooSOAPOverHTTP = new QName("http://org/example/foo", "Foo_SOAPOverHTTP");
    static {
        URL url = Foo_Service.class.getClassLoader().getResource("wsdl/FooService.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(Foo_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/FooService.wsdl");
        }       
        WSDL_LOCATION = url;
    }