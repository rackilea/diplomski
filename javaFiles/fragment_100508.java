@WebServlet("/viewuser.jsp")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int empid = (Integer)request.getSession().getAttribute("empid");
        //assuming EmployeeService is a service class that has a getEmployee method
        //that will handle the work to a dao to retrieve data from database 
        //or another data source and will return an Employee object
        Employee employee = new EmployeeService().getEmployee(empid);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("/viewuser.jsp").forward(request, response);
    }
}