@Path("/transactions")
public class TestResource<X> {

    private Class<X> jaxbClass;

    @POST
    @Path("/{transaction-id}")
    @Consumes("application/xml")
    public Response processPost(@Context Providers providers, @Context HttpHeaders httpHeaders, @PathParam("transaction-id") final long transactionId,
            final String xmlString) throws WebApplicationException, IOException {

        MessageBodyReader<X> reader = providers.getMessageBodyReader(jaxbClass, null, null, MediaType.APPLICATION_XML_TYPE);
        InputStream entityStream = new ByteArrayInputStream(xmlString.getBytes());
        final X xmlObject = reader.readFrom(jaxbClass, null, null, MediaType.APPLICATION_XML_TYPE, httpHeaders.getRequestHeaders(), entityStream);

        //insert logic here

        return Response.ok().build();
    }
}