RMIClientSocketFactory clientSocketFactory = new RMIHttpToCgiSocketFactory();
Remote stub = UnicastRemoteObject.exportObject( 
    server, 
    port, 
    clientSocketFactory, 
    RMISocketFactory.getDefaultSocketFactory() 
);