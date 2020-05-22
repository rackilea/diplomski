import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteImpl extends UnicastRemoteObject implements IRemote {
    public ArrayList<Integer> list = new ArrayList<Integer>();

    public RemoteImpl() throws RemoteException {

    }
    @Override
    public void remoteCall() throws RemoteException {
        list.add(23);
        System.out.println("In remote call: "+list.size());
    }
}