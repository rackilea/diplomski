/**
 * Get the web application class loader associated with this ServletContext.
 *
 * @return The associated web application class loader
 *
 * @throws UnsupportedOperationException    If called from a
 *    {@link ServletContextListener#contextInitialized(ServletContextEvent)}
 *    method of a {@link ServletContextListener} that was not defined in a
 *    web.xml file, a web-fragment.xml file nor annotated with
 *    {@link javax.servlet.annotation.WebListener}. For example, a
 *    {@link ServletContextListener} defined in a TLD would not be able to
 *    use this method.
 * @throws SecurityException if access to the class loader is prevented by a
 *         SecurityManager
 * @since Servlet 3.0
 */
public ClassLoader getClassLoader();