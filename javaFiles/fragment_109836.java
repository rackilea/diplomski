@WebServlet(urlPatterns = {"/ShowPersonServlet"})
public class ShowPersonServlet extends HttpServlet {

    HttpSession s; //null by default
    //...

    protected void processRequest(...) {
        //...
        //since never initialized, s is null
        user.add((Person) s.getAttribute("person"));
    }

    @Override
    protected void doGet(...) {
        //...
        //since never initialized, s is null
        s.setAttribute("person",person);
    }
}