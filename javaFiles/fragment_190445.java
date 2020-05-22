public interface TheBusiness {
    MyBusinessResponse doProcess(MyBusinessRequest request);
}

public final class MyBusinessClass implements TheBusiness {
    @Override
    public MyBusinessResponse doProcess(MyBusinessRequest request) {
        // all  the complex logic goes here.
        return response;
    }
 }

 public class MyBusinessServlet extends HttpServlet {
     private final TheBusiness theBusiness;
     private final ObjectMapper objectMapper;

     public MyBusinessServlet() {
         theBusiness = // locate and construct implementation.
         objectMapper = // Initialise Jackson deserialisation.
     }

     public void doGet(HttpServletRequest request, HttpServletResponse response) {
         final MyBusinessRequest requestBody = objectMapper.readValue(
                                              request.getInputStream(), MyBusinessRequest.class);
         final MyBusinessResponse responseBody = theBusiness.doProcess(requestBody);
         objectMapper.writeValue(response.getOutputStream(), responseBody));
     }
 }