public class WSClient {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:8080/ws/hello?wsdl");

        QName qname = new QName("http://bot.ws/", "HelloWorldImplService");

        Service service = Service.create(url, qname);

        HelloWorld hello = service.getPort(HelloWorld.class);

        System.out.println(hello.getString("bot"));

    }

}