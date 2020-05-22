//make these 2 variables as fields in Activity for example
    YourService yourService = null;
//this variable can be used for checking if your activity are binded already or not
    boolean mBounded = false;


Intent mIntent = new Intent(this, YourService.class);
startService(mIntent);
bindService(mIntent, mConnection, BIND_AUTO_CREATE);

ServiceConnection mConnection = new ServiceConnection() {
    public void onServiceDisconnected(ComponentName name) {
        mBounded = false;
        yourService = null;
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        mBounded = true;
        YourService.LocalBinder mLocalBinder = (YourService.LocalBinder) service;
        yourService= mLocalBinder.getServerInstance();
    }
};