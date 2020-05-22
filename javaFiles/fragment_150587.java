@GET
@Produces(MediaType.APPLICATION_XML)
@Path("/kml")
public String scenarioIndex(
        @QueryParam("startTime") @DefaultValue("-1") long startTime,
        @QueryParam("endTime") @DefaultValue("-1") long endTime) {
          // do the work in here
          return null;
    }