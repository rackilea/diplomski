// error handling left out for clarity
    private static void startJMXAgent() throws TheWorld {
        Registry           reg  = LocateRegistry.createRegistry(port);
        JMXConnectorServer cs   =
            JMXConnectorServerFactory.newJMXConnectorServer(
                new JMXServiceURL(
                    "service:jmx:rmi://" + host + ":" + port + "/" +
                    "jndi/rmi://" + host + ":" + port + "/" +
                    servicename
                ),
                initProperties(),
                ManagementFactory.getPlatformMBeanServer()
            );
        cs.start();
    }