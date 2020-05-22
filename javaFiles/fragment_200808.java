// create the registry
Registry rmiRegistry = LocateRegistry.createRegistry(port);
...
// connect to it
JMXConnectorServer connector =
    JMXConnectorServerFactory.newJMXConnectorServer(url,
        new HashMap<String, Object>(),
        ManagementFactory.getPlatformMBeanServer());
// do stuff with it ...

// close the connection
if (connector != null) {
    connector.stop();
}
// deregister the registry
if (rmiRegistry != null) {
    UnicastRemoteObject.unexportObject(rmiRegistry, true);
}