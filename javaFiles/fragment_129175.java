public class HelloHandler extends AbstractHandler
{
    public void handle(String target,Request baseRequest,HttpServletRequest request,HttpServletResponse response) 
        throws IOException, ServletException
    {
        // the value passed in from the client side
        String value = request.getParameter("value");

        // do stuff with that here

        // return a response
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);

        // this gets sent back down to the client-side and is alerted
        response.getWriter().println("<h1>Hello World</h1>");
    }
}