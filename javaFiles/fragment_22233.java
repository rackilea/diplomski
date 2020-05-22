public String getRemoteString()
{
    String result = "";
    try
    {
        Registry registry = LocateRegistry.getRegistry(9345);            
        IRemote serv = (IRemote) registry.lookup(IRemote.serviceName);

        result = serv.executeRemote("Test");
    }
    catch (Exception e)
    {
        System.err.println("Remoteservice exception:");
        e.printStackTrace();
    }

    return result;
}