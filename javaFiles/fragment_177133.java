@WebServlet(value="/myServlet", name="myServlet")
public class MyServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) {
        Uber uber = (Uber)config.getServletContext().getAttribute("uber");
        uber.registerServlet("myServlet", this);
    }
    //more code...
}