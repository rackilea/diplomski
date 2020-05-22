public class TestClient{
    public static void main(String []args){
        ServiceNameProxy proxy = new ServiceNameProxy();
        proxy.setEndpoint("http://localhost:8080/ServiceName/asdf");//defined in wsdl

        int i = proxy.webServiceMethod(new String(), new String());
    }
}