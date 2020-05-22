@WebListener
public class ShutdownListener implements javax.servlet.ServletContextListener{

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        try {
            ShutdownMBean shutdownMBean = new Shutdown();
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            ObjectName name = new ObjectName("com.example:type=Shutdown");
            server.registerMBean(shutdownMBean, name);
        } catch (InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException | MalformedObjectNameException e) {
        }
    }
}