import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote{
    //remote method declaration    
    public int calculate(int x,int y) throws RemoteException;
}