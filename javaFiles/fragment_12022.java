interface UpdateListener extends Remote {

  public void handleUpdate(Object update) throws RemoteException;

}

class UpdateListenerImpl implements UpdateListener {

  public void handleUpdate(Object update) throws RemoteException {
  // do something
  }

}

//somewhere in your client code
final UpdateListener listener = new UpdateListenerImpl();
UnicastRemoteObject.export(listener);