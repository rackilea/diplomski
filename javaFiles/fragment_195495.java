import java.rmi.RemoteException;
import java.rmi.server.*;

public class Function extends UnicastRemoteObject implements FunctionInterface
{
    protected Function() throws RemoteException
    {super();}

    @Override
    public double valueIn(double x) 
    {
        return 1-x;
    }
}