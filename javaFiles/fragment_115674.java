public boolean update(Argument params) {
    try {
        Class1.getDefault().getClass2().save(params);
    } catch (RemoteException e) {
        return false;
    }

    return true;
}