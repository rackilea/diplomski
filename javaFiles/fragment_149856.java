public class UserDefinedExcpetion extends WebApplicationException {

  /**
  * Create a HTTP 404 Not Found Error as plain text
  * whenever a UserDefinedExcpetion happens.
  */
  public UserDefinedExcpetion (String yourMessage) {
    super(Response.status(Responses.NOT_FOUND).
    entity(yourMessage).type("text/plain").build());
  }
}