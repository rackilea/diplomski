@Path("/helloworld")
public class HelloWorldUnmanagedExtension {

    private final HelloWorldNodeCreator nodeCreator;

    public HelloWorldUnmanagedExtension(@Context GraphDatabaseService database) {
        nodeCreator = new HelloWorldNodeCreator(database);
    }

    @POST
    @Path("/create")
    public Response createHelloWorldNode() {
        Node node = nodeCreator.createHelloWorldNode();
        return Response.ok(String.valueOf(node.getId())).build();
    }
}