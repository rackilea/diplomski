@GET
public Response demo(@Context final UriInfo uriInfoContext, final String requestBody) {
    final ObjectMapper objectMapper = objectMapperResolver.resolve(uriInfoContext.getQueryParameters());
    objectMapper.readValue(requestBody, MyClass.class);
    ...
}