@WebServlet("/RecordServlet")
public class RecordsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //it will fire on a GET request (like accessing directly to the URL
        //from the browser)
        //here you should load the data for the View (JSP)
        loadData(request);
        //forward to show the view
        request.getRequestDispatcher("hello.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //it will fire on a POST request (like submitting the form using POST method)
        String selectedRecord = request.getParameter("selectedRecord");
        System.out.println(selectedRecord);
        request.setAttribute("selectedRecord", selectedRecord);
        loadData(request);
        //forward to show the view
        request.getRequestDispatcher("hello.jsp").forward(request, response);
    }

    //method to load the data available to select
    private void loadData(HttpServletRequest request) {
        RecordService recordService = new RecordService();
        String[] records = recordService.getRecords();
        //set the data as attribute on the request to be available on the View
        request.setAttribute("records", records);
    }
}