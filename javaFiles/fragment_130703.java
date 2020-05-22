import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Addition extends UnicastRemoteObject implements Calculator{

    public Addition() throws RemoteException{
        super();
    }

    public int calculate(int x,int y) throws RemoteException{
        //define what your remote method will do
        return x+y;
    }
}