package com.blogspot.javarestlet.httpbasicauth.server.resources;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class HelloWorldAdminServerResource  extends ServerResource {
    @Get
    public String $get()
    {
        return "Hello Admin";
    }
}