@WebServlet(urlPatterns = {"/ShowPersonServlet"})
public class ShowPersonServlet extends HttpServlet {
    /*
    HttpSession s ; //moved as local variable
    Person person = new Person(); //moved as local variable
    private List<Person> user = new ArrayList<Person>(); //not sure where you want to store this
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        List<Person> personList = (List<Person>) session.getAttribute("personList");
        if (personList == null) {
            personList = new ArrayList<>();
            session.setAttribute("personList", personList);
        }
        personList.add((Person) session.getAttribute("person"));
        /*
        try (PrintWriter out = response.getWriter()) {
            //removed to shorten this answer
        }
        */
        request.getRequestDispatcher("/showPerson.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Person person = new Person();
        person.setKey(request.getParameter("txt_Key"));
        person.setFirstName(request.getParameter("txt_firstName"));
        person.setLastName(request.getParameter("txt_lastName"));
        processRequest(request, response);
        HttpSession session = request.getSession();
        session.setAttribute("person",person);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }
}