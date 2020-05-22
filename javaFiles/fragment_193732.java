ClientCallbackInterface client = new ClientImpl();

UnicastRemoteObject.exportObject(client);

Registry registry = LocateRegistry.getRegistry(serverIp, serverRegistryPort); 

Server server = (Server) registry.lookup(serviceName);

server.register(client);