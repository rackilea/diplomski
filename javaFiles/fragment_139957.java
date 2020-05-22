import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/loginServlet") //assuming you're using Servlet 3.0
public class YourServlet extends HttpServlet {

    //Jackson class that handles JSON marshalling
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    //login operation should be handled in POST
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Customer loginResult = ...; //process data and get the loginResult instance
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        //marshalling the data of your loginResult in JSON format
        String json = OBJECT_MAPPER.writeValueAsString(loginResult);
        response.getWriter().write(json);
    }
}