@RunWith(PowerMockRunner.class)
public class SomeServletTest {

    @Test
    public void onGet() throws ServletException, IOException{
        SomeServlet someServlet = PowerMock.createPartialMock(SomeServlet.class, "getServletContext");   
        ServletContext servletContext = PowerMock.createNiceMock(ServletContext.class);
        HttpServletRequest httpServletRequest = PowerMock.createNiceMock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = PowerMock.createNiceMock(HttpServletResponse.class);

        someServlet.getServletContext();
        PowerMock.expectLastCall().andReturn(servletContext);

        servletContext.getAttribute("test");
        PowerMock.expectLastCall().andReturn("hello");

        PowerMock.replay(someServlet, servletContext, httpServletRequest, httpServletResponse);

        someServlet.doGet(httpServletRequest, httpServletResponse);
    }
}