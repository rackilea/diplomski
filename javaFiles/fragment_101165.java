package com.blogspot.javarestlet.httpbasicauth.server.app;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.data.Protocol;

public class Main {
    public static void main(String[] args) throws Exception
    {
        // Create a component
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8151);
        component.getClients().add(Protocol.HTTP);

        // Create an application
        Application application = new ClientAppStart();

        // Attach the application to the component and start it
        component.getDefaultHost().attach("/userx",application);
        component.getDefaultHost().attach("/admin/accounts/abc123",new AdminAppStart());
        component.start();
    }
}