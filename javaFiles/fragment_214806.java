@GET
@Produces("text/html")
public Response welcome()
{
return Response.ok("This should now work in IE").build();
}