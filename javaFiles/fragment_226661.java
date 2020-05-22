public class HelloServlet extends HttpServlet {

    @WebServiceRef(HelloMessengerService.class) // class with @WebServiceClient
    private HelloMessenger port; // the SEI

    ...
}