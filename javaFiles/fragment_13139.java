public class Prenotation extends HttpServlet {
    private Database database;

    @Override
    public void init()  throws ServletException {
        super.init();
        this.database = new Database(new ConnectionFactory());  // no statics needed!
    }

protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session=request.getSession();
     String idPrenotazione = request.getParameter("idPrenotazione");
     String email = request.getParameter("email");
     int typeRoom = Integer.parseInt(request.getParameter("typeRoom"));;
     String arrivalDate = request.getParameter("arrivalDate");
     String departureDate = request.getParameter("departureDate");
     response.setContentType("text/html;charset=UTF-8");
     PrintWriter out = response.getWriter();

    // use the method from `Database` which knows how to query the DB.
    int totalReservations = database.getTotalReservations(typeRoom, arrivalDate, departureDate);

    // more processing... and forward to the JSP
}