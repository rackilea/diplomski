import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.realm.GenericPrincipal;
import org.apache.catalina.valves.ValveBase;

public class RemoteUserValve extends ValveBase {

    public RemoteUserValve() {
    }

    @Override
    public void invoke(final Request request, final Response response)
            throws IOException, ServletException {
        final String username = "myUser";
        final String credentials = "credentials";
        final List<String> roles = new ArrayList<String>();

            // Tomcat 7 version
        final Principal principal = new GenericPrincipal(username, 
                            credentials, roles);
            // Tomcat 6 version:
            // final Principal principal = new GenericPrincipal(null, 
            //              username, credentials, roles);


        request.setUserPrincipal(principal);

        getNext().invoke(request, response);
    }

}