public class FooServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        Bar bar = new Bar();
        request.setAttribute("bar", bar.getFooBar() );
        request.getRequestDispatcher("/myPage.jsp").forward(request, response);
    }
}