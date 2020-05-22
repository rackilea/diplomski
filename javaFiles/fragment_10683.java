import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Addition extends UnicastRemoteObject implements
        AdditionalInterface {
    private static final long serialVersionUID = 1L;

    public Addition() throws RemoteException {
        // TODO Auto-generated constructor stub
    }

    public int Add(int a, int b) {
        return a + b;
    }
}