public interface MyRemoteMethods {
    String myMethod() throws RemoteException; // this Ex is required
}

public interface MyRemote extends EJBObject, MyRemoteMethods { 
}

public interface MyRemoteHome extends EJBHome {
    public MyRemote create() throws CreateException, RemoteException;
}