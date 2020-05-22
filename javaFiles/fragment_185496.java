public class CustomXmlRpcServlet extends XmlRpcServlet
{

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    Cookie[] cookies = request.getCookies();
    //...
    super.doPost(request, response);
  }
  //...
  //Tough we do not have other customization, here it is possible to add additional method and/or override existing ones
}