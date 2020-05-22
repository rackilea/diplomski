String fileName = System.getProperty("jboss.server.config.url") + "/" + "jndi-remote.properties";

Properties properties = null;
try {
    URL url = new URL(fileName);
    if(new File(url.toURI()).exists()) { 
        properties = new Properties();
        properties.load(url.openStream());
        LOGGER.info("The file " + "jndi-remote.properties" + " was loaded from " + fileName);
    }
} catch (MalformedURLException e) {
    //throw
} catch (URISyntaxException e) {
    //throw
} catch (IOException e) {
    //throw
}