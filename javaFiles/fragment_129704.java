@WebService()
public class MyWebService{
  @Resource
  private WebServiceContext wsContext;
  @WebMethod
  public void echoHello(String msg) {
    System.out.println("Username = " + wsContext.getUserPrincipal().getName());
  }
}