@WebServlet("/OutboundHttpServlet")
public class OutboundHttpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public OutboundHttpServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getParameter("url");
        response.setContentType("text/html");
        int code = getCode(uri);

        if(code >= 200 && code <= 299) {
            response.setHeader("Location", uri);
        }

        response.setHeader("Location", new String("yourerrorpage.jsp"));
    }

     public int getCode(String uri) throws IOException {

          HttpURLConnection conn = null;
          int response = -1;
          URL url  = new URL(uri); 

          try {
             conn = (HttpURLConnection) url.openConnection();
             conn.setRequestMethod("GET");
             conn.connect();

             response = conn.getResponseCode(); 
          } catch (IOException e) { 
             conn.disconnect();
          }

         return response;
     } 
}