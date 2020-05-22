package com.tuts;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService_1")
public class UserService {
   @GET
   @Path("/get_data")
   @Produces(MediaType.APPLICATION_JSON)

   public String getUser() {
      String reponse = "This is standard response from REST";
      return reponse;
   }
}