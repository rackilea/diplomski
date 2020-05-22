public interface Login extends Remote
{
    Session login(String username, char[] password /* or whatever */)
        throws LoginException, RemoteException;
}

public interface Session extends Remote
{
    void logout() throws RemoteException;
    void deposit(...) throws RemoteException;
    void withdraw(...) throws RemoteException;
}

public class LoginImpl extends UnicastRemoteObject implements Login
{
    public Session login(String username, char[] password)
        throws LoginException, RemoteException
    {
        // username/password check; if it fails throw a LoginException
        return new SessionImpl(username); // or whatever
    }
}

public class SessionImpl extends UnicastRemoteObject implements Session, Unreferenced
{
    public void logout() throws RemoteException
    {
        unexportObject(this, true);
    }

    public void unreferenced()
    {
        unexportObject(this, true); // needs to be in a try/catch block of course
    }

    // etc
}