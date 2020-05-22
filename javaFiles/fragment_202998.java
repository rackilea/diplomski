@Test
public void onGet() throws ServletException, IOException {
  HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
  HttpServletResponse httpServletResponse = Mockito.mock(HttpServletResponse.class);
  final ServletContext servletContext = Mockito.mock(ServletContext.class);
  SomeServlet someServlet = new SomeServlet(){
    public ServletContext getServletContext() {
      return servletContext; // return the mock
    }
  };

  Mockito.doReturn("hello").when(servletContext).getAttribute("test");

  someServlet.doGet(httpServletRequest, httpServletResponse);
}