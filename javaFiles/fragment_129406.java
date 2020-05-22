package com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("multi")
public class MultipleParam
{
    @GET
    @Path("{day}/{month}/{year}")
    public Response getUserHistory(@PathParam("day") int day, @PathParam("month") int month,
        @PathParam("year") int year)
    {
        return Response.status(200).entity(day + "-" + month + "-" + year).build();
    }
}