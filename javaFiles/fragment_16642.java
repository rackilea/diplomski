package org.stack;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;
import org.apache.catalina.AccessLog;

public class LoginValve extends ValveBase implements AccessLog {

    // Should this valve set request attributes for IP address, hostname, protocol and port used for the request?
    boolean requestAttributesEnabled = false;

    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        // null 
        System.out.println("LoginValve-invoke: " + request.getRemoteUser());
        getNext().invoke(request, response);
    }

    @Override
    public void log(Request request, Response response, long time) {
        // remote user
        System.out.println("LoginValve-log: " + request.getRemoteUser());
    }

    @Override
    public void setRequestAttributesEnabled(boolean requestAttributesEnabled) {
        this.requestAttributesEnabled = requestAttributesEnabled;
    }

    @Override
    public boolean getRequestAttributesEnabled() {
        return requestAttributesEnabled;
    }
}