import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Subtraction extends UnicastRemoteObject implements Calculator{

    public Subtraction() throws RemoteException{
        super();
    }

    public int calculate(int x,int y) throws RemoteException{
        return x-y;
    }
}