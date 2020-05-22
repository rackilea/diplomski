/**
 * Initialize/destroy ModuleManager on context init/destroy
 * @see {@link ContextLoaderListener}
 * @author Ludovic Guillaume
 */
public class ModuleContextLoaderListener extends ContextLoaderListener {
    public ModuleContextLoaderListener() {
        super();
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        // initialize ModuleManager, which will scan the given folder
        // TODO: param in web.xml
        ModuleManager.init(event.getServletContext().getRealPath("WEB-INF"), "/dev/temp/modules");

        super.contextInitialized(event);
    }

    @Override
    protected WebApplicationContext createWebApplicationContext(ServletContext sc) {
        XmlWebApplicationContext context = (XmlWebApplicationContext)super.createWebApplicationContext(sc);

        // set the current classloader
        WebApplicationUtils.setCurrentClassLoader(context);

        return context;
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);

        // destroy ModuleManager, dispose every module classloaders
        ModuleManager.destroy();
    }
}