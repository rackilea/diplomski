package rest;

import entities.Tourist;
import entities.TouristWrapper;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/so")
public class SOResource {

    @GET
    @Path("/tourists/{id}")
    @Produces("application/json")
    public TouristWrapper loginUser(@PathParam("id") int id) {
        Tourist tourist = new Tourist(id, "foo@example.com", "John", "Doe");
        TouristWrapper touristWrapper = new TouristWrapper(tourist);
        return touristWrapper;
    }
}