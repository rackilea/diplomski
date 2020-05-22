import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;

private static final QName SERVICE_NAME = new QName(
        "http://www.service-now.com/foo",
        "ServiceNow_foo");

private ServiceNowSoap_ServiceNowSoap_Client() {
}

public static void main(String args[]) throws java.lang.Exception {
    URL wsdlURL = ServiceNowFoo.WSDL_LOCATION;
    if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
        File wsdlFile = new File(args[0]);
        try {
            if (wsdlFile.exists()) {
                wsdlURL = wsdlFile.toURI().toURL();
            } else {
                wsdlURL = new URL(args[0]);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    ServiceNowFoo ss = new ServiceNowFoo(wsdlURL,
            SERVICE_NAME);

    ServiceNowSoap port = ss.getServiceNowSoap();

    Client client = ClientProxy.getClient(port);
    HTTPConduit http = (HTTPConduit) client.getConduit();
    http.getAuthorization().setUserName("theusername");
    http.getAuthorization().setPassword("thepassword");

    // Do your work here.
}