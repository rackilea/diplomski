private static class SelfConfiguration extends AbstractConfiguration
{
    @Override
    public void configure(WebAppContext context) throws Exception
    {
        // Emulates web.xml.
        webapp.addEventListener(...);
        webapp.setInitParameter("resteasy.role.based.security", "true");
        webapp.addFilter(...);
    }
}

public static void main(String[] args) throws Exception
{
    Server server = new Server(8080);

    WebAppContext webapp = new WebAppContext();
    webapp.setContextPath("/");
    if (useWebXml)
    {
        webapp.setConfigurationClasses(WebAppContext.getDefaultConfigurationClasses());
    } 
    else 
    {
        webapp.setConfigurations(new Configuration[] { 
            new SelfConfiguration() 
        });
    }
    webapp.setWar("path/to/my/test.war");
    webapp.setParentLoaderPriority(true);
    server.setHandler(webapp);
    server.start();
    server.join();
}