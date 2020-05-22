public interface RemoteLogin extends Remote
{
    RemoteSession login() throws RemoteException;
}

public interface RemoteSession extends Remote
{
    void logout() throws RemoteException;
    void myMethod(...) throws RemoteException; // whatever you need
}

public class RemoteLoginImpl extends UnicastRemoteObject implements RemoteLogin
{
  // ...
  public RemoteSession login()
  {
    // ...
    return new RemoteSessionImpl(); // whatever arguments you need
  }
}

public class RemoteSessionImpl extends UnicastRemoteObject implements RemoteSession, Unreferenced
{
  // ...
}