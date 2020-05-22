package com.coderskitchen.thegreeter.rest;

import com.coderskitchen.thegreeter.greetings.GreetingService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/greet")
@ManagedBean
public class Greeter {
    @Inject
    GreetingService gs;
    @GET
    @Path("{name}")
    public String greetSomeone(@PathParam("name") String name) {
        return gs.greetSomeone(name);
    }
}