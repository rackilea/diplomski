private final ServiceConnection connection = new ServiceConnection() {
    @Override
    public void onServiceConnected(ComponentName className, IBinder binder) {

        Log.i("BumpTest", "onServiceConnected");
        api = IBumpAPI.Stub.asInterface(binder);
        new Thread() {
            public void run() {
                try {
                    api.configure("API_KEY",
                            "Bump User");
                } catch (RemoteException e) {
                    Log.w("BumpTest", e);
                }

            }
        }.start();

        Log.d("Bump Test", "Service connected");
    }

    @Override
    public void onServiceDisconnected(ComponentName className) {
        Log.d("Bump Test", "Service disconnected");
    }
};