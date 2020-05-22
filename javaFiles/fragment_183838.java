@WebServlet("/Controler")
public class Controler extends HttpServlet {
    private Properties properties;

    @Override
    public void init() {
        properties = PropLoader.load(getServletConfig().getServletContext());
    }
}

public class PropLoader {

    private final static String FILE_PATH = "/file.properties";

    public static Properties load(ServletContext context) {
        Properties properties = new Properties();
        properties.load(context.getResourceAsStream(FILE_PATH));
        return properties;
    }
}