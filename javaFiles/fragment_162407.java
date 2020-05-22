package another;

import javax.jws.WebService;

@WebService
public interface IWebServiceTest {
    String sayHello(String name);
}

package another;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "http://localhost:9191/webServiceTest?wsdl";
        String namespace = "http://another/";
        QName serviceQN = new QName(namespace, "WebServiceTestService");
        Service service = Service.create(new URL(url), serviceQN);

        String portName = "WebServicePort";
        QName portQN = new QName(namespace, portName);

        IWebServiceTest sample = service.getPort(portQN, IWebServiceTest.class);
        String result = sample.sayHello("blabla");
        System.out.println(result);
    }
}