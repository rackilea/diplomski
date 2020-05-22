package com.xxx.orderstatus.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestWebService 
{

    @GET
    @Path("/hello-world")
    public Response checkAuth(@QueryParam("userId") String  userId) {

        return Response.status(200).entity("Hello").build();
    }


}