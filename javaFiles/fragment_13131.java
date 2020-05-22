@PUT
@Path("/availableQuestions")
@Produces({ MediaType.APPLICATION_JSON })
public Response method1() {}

@PUT
@Path("/{questionId}")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public Response method2(@PathParam("questionId") long questionId) {}