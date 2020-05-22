import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class WebServiceConsumerPort<P>{


    protected P puerto;
    private static Logger log = LoggerFactory.getLogger(WebServiceConsumerPort.class);

    public void creaPuerto(String url, String timeoutS, Class<P> tipoClase) {

        try {
            Long timeout = Long.parseLong(timeoutS);
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(tipoClase);
            factory.setAddress(url);
            puerto = (P) factory.create();

            Client client = ClientProxy.getClient(puerto);

            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) client.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setAllowChunking(false);
                policy.setConnectionTimeout(timeout * 1000);
                policy.setReceiveTimeout(timeout * 1000);
                conduit.setClient(policy);
            }
            nIntento = 0;
        } catch (Exception e) {
            puerto = null;
            nIntento++;
        }
    }
}