ContextHandlerCollection contexts = new ContextHandlerCollection();
    server.setHandler(contexts);

    DeploymentManager deployer = new DeploymentManager();
    deployer.setContexts(contexts);
    deployer.setContextAttribute(
            "org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
            ".*/servlet-api-[^/]*\\.jar$");

    WebAppProvider webapp_provider = new WebAppProvider();
    // The directory to monitor for WAR + XML files
    webapp_provider.setMonitoredDirName("/opt/jetty/webapps");
    webapp_provider.setScanInterval(1); // how often to scan
    webapp_provider.setExtractWars(true);
    webapp_provider.setTempDir(new File("/opt/jetty/work"));

    deployer.addAppProvider(webapp_provider);
    server.addBean(deployer);