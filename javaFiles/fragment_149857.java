@Provider
    public class IOExceptionMapper implements ExceptionMapper<java.io.IOException> {
      public Response toResponse(java.io.IOException) {
/** Mapper which maps to IOExcpetion and gets called automatically by the JAXRS runtime when this exception occurs. Throw a 404 when this exception occurs.**/
        return   Response.status(404).entity(ex.getMessage()).type("text/plain").build();
      }
    }