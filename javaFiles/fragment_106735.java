import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;

...

JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

//factory.getInInterceptors().add(new LoggingInInterceptor());
//factory.getOutInterceptors().add(new LoggingOutInterceptor());

factory.setServiceClass(IAbc.class);
factory.setAddress("https://hiddendomain.com/abc/abc.svc/soap"); <- must be /soap there, otherwise 404

IAbc info = (IAbc) factory.create();

Client client = ClientProxy.getClient(info);
HTTPConduit http = (HTTPConduit) client.getConduit();

http.getAuthorization().setUserName("user");
http.getAuthorization().setPassword("pass");

String abc = info.abc();