public class startServer extends HttpServlet
{
    public static boolean isRegistered = false;    
    public IRemote service = new RemoteImpl();

    @Override
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);        
        if (!isRegistered)
        {
            try
            {                
                IRemote stub = (IRemote) UnicastRemoteObject.exportObject(service, 0);
                Registry registry = LocateRegistry.createRegistry(9345);
                registry.rebind(IRemote.serviceName, stub);
                System.out.println("Remote service bound");
                isRegistered = true;
            }
            catch (Exception e)
            {
                System.err.println("Remote service exception:");
                e.printStackTrace();
            }
        }
    }
}