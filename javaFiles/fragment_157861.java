List<String> configurations = new ArrayList<String>();
configurations.add("jetty.xml"); //$NON-NLS-1$

// use pre-configured jetty xml files to construct a server instance
if (System.getProperty("jetty.sslContext.keyStorePath") != null) { //$NON-NLS-1$
    configurations.add("jetty-ssl.xml"); //$NON-NLS-1$
    configurations.add("jetty-ssl-context.xml"); //$NON-NLS-1$
    configurations.add("jetty-https.xml"); //$NON-NLS-1$
} else {
    configurations.add("jetty-http.xml"); //$NON-NLS-1$
}

XmlConfiguration last = null;
List<Object> objects = new ArrayList<Object>();

for (String configFile : configurations) {
    InputStream configStream = null;

    File xmlConfiguration = new File(webserverHome, CONFIG_LOCATION + configFile);
    if (xmlConfiguration.exists()) {
        configStream = new FileInputStream(xmlConfiguration);
        logger.info("Using custom XML configuration {}", xmlConfiguration); //$NON-NLS-1$
    } else {
        // configStream = ... // read from bundle
        logger.info("Using default XML configuration {}/{}", Activator.PLUGIN_ID, CONFIG_LOCATION + configFile); //$NON-NLS-1$
    }

    XmlConfiguration configuration = new XmlConfiguration(configStream);
    if (last != null) {
        configuration.getIdMap().putAll(last.getIdMap());
    }
    objects.add(configuration.configure());
    last = configuration;
}

// first object is a Server instance because of the jetty.xml
server = (Server) objects.get(0);