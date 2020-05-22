@GET    
@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response search(@QueryParam("query") String queryParam) throws Exception                        
{       
        Myobj obj = new Gson().fromJson(queryParam, Myobj.class);           
        // rest of code