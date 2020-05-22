import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
...
Client client = ClientProxy.getClient(port);
HTTPConduit conduit = (HTTPConduit) client.getConduit();
HTTPClientPolicy policy = conduit.getClient();
if(policy == null) {
   policy = new HTTPClientPolicy();
}
policy.setAllowChunking(false);