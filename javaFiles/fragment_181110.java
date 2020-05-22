import com.sun.xml.ws.developer.JAXWSProperties;
import java.net.URL;
import javax.xml.ws.BindingProvider;

public void foo(Object service) {
    if (service instanceof BindingProvider) {
        BindingProvider bp = (BindingProvider)service;
        Map<String, Object> ctx = bp.getRequestContext();
        ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, new URL("http://localhost/url-to-endpoint"));
        ctx.put(JAXWSProperties.CONNECT_TIMEOUT, 10000);
        ctx.put(JAXWSProperties.REQUEST_TIMEOUT, 60000);
        ctx.put(BindingProvider.USERNAME_PROPERTY, "auth_user");
        ctx.put(BindingProvider.PASSWORD_PROPERTY, "auth_password");            
    }
}