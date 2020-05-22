public class RestResource {

    @Context
    private HttpServletRequest httpServletRequest;


 @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() {
    RequestContext requestContext = (RequestContext) httpServletRequest.getAttribute(RequestConstants.REQUEST_CONTEXT);
 // Get whatever the value set in your request context
 String userName = requestContext.requestContext.getQueryString("userName");
    return userName;
  }

}