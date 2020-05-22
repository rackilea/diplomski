package com.sentiment360.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloWorld {

    @GET
    @Path("/json/{p}")
    @Produces({"application/json"})
    public String getHelloWorldJSON(@PathParam("p") String param) {
        return "{\"result\":\"" + param + "\"}";
    }

    @GET
    @Path("/xml/{p}")
    @Produces({"application/xml"})
    public String getHelloWorldXML(@PathParam("p") String param) {
        return "<xml><result>" + param + "</result></xml>";
    }
}