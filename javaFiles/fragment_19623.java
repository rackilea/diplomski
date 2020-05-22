@Provider
public class UnexpectedExceptionMapper implements ExceptionMapper<Exception>
{
  @Override
  public Response toResponse(final Exception exception)
  {
    ResponseBuilder builder = Response.status(Status.BAD_REQUEST)
                                      .entity(jsonError(exception))
                                      .type(MediaType.APPLICATION_JSON);
    return builder.build();
  }

  private String jsonError(final Exception exception)
  {
    return "{\"error\":\"" + exception.getMessage() + "\"}";
  }
}