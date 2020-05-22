package com.blogspot.javarestlet.httpbasicauth.server.resources;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class HelloWorldClientServerResource extends ServerResource {
@Get
public String $get()
{
    return "Hello Client";
}
}