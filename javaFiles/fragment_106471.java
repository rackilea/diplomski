package org.example;

import java.util.List;
import javax.ejb.*;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@LocalBean
@Path("/customers")
public class CustomerService {

    @PersistenceContext(unitName="CustomerService", 
                        type=PersistenceContextType.TRANSACTION)
    EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{id}")
    public Customer read(@PathParam("id") long id) {
        return entityManager.find(Customer.class, id);
    }

}