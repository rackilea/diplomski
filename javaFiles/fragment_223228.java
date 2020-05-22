private ServiceConnection myServiceConnection = new ServiceConnection() {
    @Override
    // IBinder interface is through which we receive the service object for communication.
    public void onServiceConnected(ComponentName name, IBinder binder) {
        RandomCharacterServiceBinder myBinder = (RandomCharacterServiceBinder) binder;
        isServiceOn = true;
        myService = myBinder.getService();
        Toast.makeText(context,"Service connected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        isServiceOn = false;
        myService = null;
    }
};