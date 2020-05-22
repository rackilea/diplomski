public class MyHttpRequestHandler implements HttpRequestHandler {

@Override
public void handleRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request == null) {
            throw new InvalidRequestException("the request object is null");
        }
   }
}