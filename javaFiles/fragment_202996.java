public class SomeServletTest {

    @Test
    public void onGet() throws ServletException, IOException{
        HttpServletRequest httpServletRequest = EasyMock.createNiceMock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = EasyMock.createNiceMock(HttpServletResponse.class);
        final ServletContext servletContext = EasyMock.createNiceMock(ServletContext.class);
        SomeServlet someServlet = new SomeServlet(){
            public ServletContext getServletContext() {
                return servletContext; // return the mock
            }
        };

        EasyMock.expect(servletContext.getAttribute("test")).andReturn("hello");
        EasyMock.replay(servletContext, httpServletRequest, httpServletResponse);

        someServlet.doGet(httpServletRequest, httpServletResponse);
    }
}