@Override
public boolean register(IClient client) throws RemoteException {
    FutureTask<Boolean> register = new FutureTask<>(() ->
        if(!clients.contains(client)) {
            clients.add(client);
            return true;
        }
        return false;
    );
    Platform.runLater(register);
    return register.get();
}

@Override
public boolean unRegister(IClient client) throws RemoteException {
    FutureTask<Boolean> unRegister = new FutureTask<>(() ->
        if(clients.contains(client)) {
            clients.remove(client);
            return true;
        }
        return false;
    );
    Platform.runLater(unRegister);
    return unRegister.get();
}