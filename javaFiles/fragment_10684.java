import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class AdditionServer {
    public static void main(String[] argv) throws RemoteException {
        Addition Hello = new Addition();

        int port = 1091;

        try { // special exception handler for registry creation
            LocateRegistry.createRegistry(port);
            System.out.println("java RMI registry created.");
        } catch (RemoteException e) {
            // do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        }

        String hostname = "0.0.0.0";

        String bindLocation = "//" + hostname + ":" + port + "/Hello";
        try {
            Naming.bind(bindLocation, Hello);
            System.out.println("Addition Server is ready at:" + bindLocation);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Addition Serverfailed: " + e);
        }
    }
}