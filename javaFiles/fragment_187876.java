@Path("/foo") 
public class FooResource {

    @Context
    protected UriInfo info;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Foo getById(@QueryParam("id") int id) {
         // get Foo by id
         Foo = ....

         // return an instance of Foo and let Jersey convert it to XML
         // or JSON depending on the "Accept" header that the client sent
         return foo;
    } 

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(Foo instance)
    {
         // let Jersey deserialize the request body from JSON or XML.
         // save the instance however you want
         int id = fooService.save(instance);

         // return a 204 "created" with a "Location" header
         URI location = info.getAbsolutePathBuilder().path("{id}").build(id);
     return Response.created(location).build();
    }