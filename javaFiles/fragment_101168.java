package com.blogspot.javarestlet.httpbasicauth.server.resources;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class HelloWorldDefaultServerResource extends ServerResource{
@Get
public String $get()
{
    return "please enter a sub-url after abc123";
}
}