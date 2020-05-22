@GET
@Path(value="/authentication/{scac}/employees/{id}")
@Produces({ MediaType.APPLICATION_JSON })
public String verifyEmployee(@PathParam("scac") String scac,
                             @PathParam("id") String id,
                             @QueryParam("pin") String pin,
                             @QueryParam("reason") String reason);