@Path("/variable")
public class VariableResource {
    @Inject private VariableManager variableManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVariables() {
        return Response.ok(variableManager.getVariables()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    // Same method but without using the JAX-RS Response object
    public List<Variable> getVariablesAlso() {
        return variableManager.getVariables();
    }
}