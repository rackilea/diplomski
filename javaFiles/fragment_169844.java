/**
 * Meant to be called from a different thread, once the spark app is running
 * This is probably only going to be used during the integration testing process, not ever in prod!
 *
 * @return the port it's running on
 */
public static int awaitRunningPort() throws Exception {
    awaitInitialization();
    //I have to get the port via reflection, which is fugly, but the API doesn't exist :(
    //Since we'll only use this in testing, it's not going to kill us
    Object instance = getInstance();
    Class theClass = instance.getClass();
    Field serverField = theClass.getDeclaredField("server");
    serverField.setAccessible(true);
    Object oneLevelDeepServer = serverField.get(instance);

    Class jettyServerClass = oneLevelDeepServer.getClass();
    Field jettyServerField = jettyServerClass.getDeclaredField("server");
    jettyServerField.setAccessible(true);
    //Have to pull in the jetty server stuff to do this mess
    Server jettyServer = (Server)jettyServerField.get(oneLevelDeepServer);

    int acquiredPort = ((ServerConnector)jettyServer.getConnectors()[0]).getLocalPort();

    log.debug("Acquired port: {}", acquiredPort);
    return acquiredPort;
}