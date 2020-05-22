@WebService(serviceName="MyServerService", name="MyServer")
@XmlSeeAlso({Child1.class, Child2.class})
public class MyServer {
    private int count=0;

    @WebResult(name="test")
    @WebMethod
    public Parent getOne() { 
        return ++count%2==0?new Child1():new Child2();
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/path", new MyServer());
    }
}