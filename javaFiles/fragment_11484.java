class ExceptionAction implements MockAction {
  private final Exception exception;

  private ExceptionAction(final Exception exception) {
    this.exception = exception;
  }

  public void performAction(final MockWebServiceServer server) {
    server.expect(anything()).andRespond(withException(exception);
  }

}

class ResourceAction implements MockAction {

  private final Resource resource;

  private ResourceAction(final Resource resource) {
    this.resource = resource;
  }

  public void performAction(final MockWebServiceServer server) {
    /* I've left out the exception handling */
    server.expect(anything()).andRespond(withSoapEnvelope(resource));
  }
}