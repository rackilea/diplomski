public class CounterServer {
    public static void main(String args[]) {
        try {    
            Registry r = LocateRegistry.createRegistry(4711);

            ICounter counter = new Counter();
            r.rebind("Counter", counter);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}