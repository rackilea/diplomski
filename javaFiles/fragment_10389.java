public class Demo extends HttpServlet{

    public void doGet(HttpServletRequest req , HttpServletRespaonse res)
            throws ServletException, IOException {
        res.setContentType(text/html);
        PrintWritter pr = res.getWriter();
        pr.println("i am in servlet");
        RequestDispatcher rd = req.getRequestDispatcher("abc.jsp");
        rd.forward();
    }
}