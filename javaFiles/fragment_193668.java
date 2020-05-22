public class Includer {

  public static String include(String resource) {
    FacesContext context = FacesContext
        .getCurrentInstance();
    ExternalContext ext = context.getExternalContext();
    include(ext.getContext(), ext.getRequest(), ext
        .getResponse(), resource);
    return "";
  }

  private static void include(Object context,
      Object request, Object response, String resource) {
    ServletContext servletContext = (ServletContext) context;
    ServletRequest servletRequest = (ServletRequest) request;
    ServletResponse servletResponse = (ServletResponse) response;
    RequestDispatcher dispatcher = servletContext
        .getRequestDispatcher(resource);
    try {
      dispatcher.include(servletRequest, servletResponse);
    } catch (IOException e) {
      throw new FacesException(e);
    } catch (ServletException e) {
      throw new FacesException(e);
    }
  }

}