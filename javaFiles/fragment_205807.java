public class MyServlet extends HttpServlet {
    private volatile Map<String, String> properties;
    private Object lock = new Object();

    public void init() {
        properties = ...; // from jdbc call
    }

    ...
}