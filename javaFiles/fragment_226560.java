@RequireHttpImplementation
@Component(name="sse", property={
    HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN+"=/sse/*",
    HttpWhiteboardConstants.HTTP_WHITEBOARD_FILTER_ASYNC_SUPPORTED+"=true",
    HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_ASYNC_SUPPORTED+"=true"},
    service=Servlet.class)
public final class ServerSideEventServlet extends HttpServlet
{
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException
   {
   }
}