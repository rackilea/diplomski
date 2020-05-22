package com.blogspot.javarestlet.httpbasicauth.server.app;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.blogspot.javarestlet.httpbasicauth.server.resources.HelloWorldClientServerResource;

public class ClientAppStart extends Application {
@Override
public Restlet createInboundRoot() {
    Router router = new Router();
    router.attach("/clientres/hello", HelloWorldClientServerResource.class);
    return router;
}
}