public class ControlServlet extends HttpServlet {
    @Autowired
    private SingerDao singerdao; 

    public void init(ServletConfig cfg) {
        super.init(cfg);
        WebApplicationContextUtils
            .getWebApplicationContext(cfg.getServletContext())
            .getAutowireCapableBeanFactory()
            .autowireBean(this);
    } 
    ...
}