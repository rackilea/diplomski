package de.demo.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.*;

@Path( "/demo" )
public class DemoService
{
   @GET
   @Produces(MediaType.TEXT_PLAIN)
   @Path("/api")
   public Response getCsv() {
       StreamingOutput stream = new StreamingOutput() {
          public void write(OutputStream os) throws ... {
             Writer writer = new BufferedWriter(new OutputStreamWriter(os));
             writer.write( /* CSV data */ );            
             writer.flush();
          }
       };

       return Response.ok(stream).build();
   }
}