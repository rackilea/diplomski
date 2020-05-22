public static void publishAndRun(int port, String name, BatchServer server) throws RemoteException, AlreadyBoundException, NotBoundException
{
    Registry registry = LocateRegistry.createRegistry(port);
    GPRSService stub = (BatchService) UnicastRemoteObject.exportObject(server, 0);
    try
    {
        registry.bind(name, stub);
        try
        {
            server.run();
        }
        finally
        {
            registry.unbind(name);
        }
    }
    finally
    {
        UnicastRemoteObject.unexportObject(server, true);
    }
}