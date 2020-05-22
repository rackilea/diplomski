package org.java.learning1;

//import javax.websocket.server.PathParam; <-- incorrect import
import javax.ws.rs.PathParam;   // <<-- correct import
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

@Path("/firstRest")
public class firstRest {

    @GET
    @Produces(MediaType.TEXT_HTML) // No quotes like stdunbar said in the comments 
    @Path("/{name}") // missing slash before name
    public String sendResponse(@Context HttpHeaders httpHeaders, @PathParam("name") String name){
        String greeting = "hello " + name; // concatenate the string with the variable name
        return greeting;
    }
}