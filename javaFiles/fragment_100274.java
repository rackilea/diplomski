ContextHandlerCollection contexts = new ContextHandlerCollection();

DeploymentManager deployer = new DeploymentManager();
if(debugIsEnabled)
{
    DebugListener debug = new DebugListener(System.err, true, true, true);
    server.addBean(debug);
    deployer.addLifeCycleBinding(new DebugListenerBinding(debug));
}
deployer.setContexts(contexts);
deployer.setContextAttribute(
    "org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
    ".*/[^/]*servlet-api-[^/]*\\.jar$|.*/javax.servlet.jsp.jstl-.*\\.jar$|.*/[^/]*taglibs.*\\.jar$");

WebAppProvider webAppProvider = new WebAppProvider();
webAppProvider.setMonitoredDirName(jettyBase + "/webapps");
webAppProvider.setDefaultsDescriptor(jettyHome + "/etc/webdefault.xml");
webAppProvider.setScanInterval(1);
webAppProvider.setExtractWars(true);
webAppProvider.setConfigurationManager(new PropertiesConfigurationManager());
webAppProvider.addLifeCycleListener(new CentralizedWebAppLoggingBinding());