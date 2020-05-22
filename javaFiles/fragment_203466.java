public class DefaultServlet extends HttpServlet
{   
    private static final long serialVersionUID = 1L;

    // Tomcat, Jetty, JBoss, and GlassFish 
    private static final String COMMON_DEFAULT_SERVLET_NAME = "default";

    // Resin 
    private static final String RESIN_DEFAULT_SERVLET_NAME = "resin-file";

    // WebLogic 
    private static final String WEBLOGIC_DEFAULT_SERVLET_NAME = "FileServlet";

    // WebSphere 
    private static final String WEBSPHERE_DEFAULT_SERVLET_NAME = "SimpleFileServlet";


    public String scanDefaultServlet(){
        if(this.getServletContext().getNamedDispatcher(COMMON_DEFAULT_SERVLET_NAME) != null) {
            return COMMON_DEFAULT_SERVLET_NAME;
        } else if(this.getServletContext().getNamedDispatcher(RESIN_DEFAULT_SERVLET_NAME) != null) {
            return RESIN_DEFAULT_SERVLET_NAME;
        } else if(this.getServletContext().getNamedDispatcher(WEBLOGIC_DEFAULT_SERVLET_NAME) != null){
            return WEBLOGIC_DEFAULT_SERVLET_NAME;
        } else if(this.getServletContext().getNamedDispatcher(WEBSPHERE_DEFAULT_SERVLET_NAME) != null){
            return WEBSPHERE_DEFAULT_SERVLET_NAME;
        } else {
            throw new IllegalStateException("Cannot determine what Server you currently use");
        }       
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        RequestDispatcher rd = getServletContext().getNamedDispatcher(this.scanDefaultServlet());
        HttpServletRequest wrapped = new HttpServletRequestWrapper(req) {
                public String getServletPath() {return "";}
        };
        rd.forward(wrapped, resp);
    }
}