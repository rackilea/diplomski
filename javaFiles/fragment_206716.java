public class BumpConnection {

    protected Context context; 
    private IBumpAPI api;
    private static BumpConnection sharedManager;
    public static synchronized BumpConnection getSharedManager(Context context) {
        if (sharedManager == null) {
            sharedManager = new BumpConnection(context);
        }
        return sharedManager;
    }

    private BumpConnection(Context context){
        this.context = context; 
        context.bindService(new Intent(IBumpAPI.class.getName()), connection,
                Context.BIND_AUTO_CREATE);
    }



    public IBumpAPI getApi() {
        return api;
    }

    public void setApi(IBumpAPI api) {
        this.api = api;
    }



    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder binder) {

            Log.i("BumpTest", "onServiceConnected");
            api = IBumpAPI.Stub.asInterface(binder);
            new Thread() {
                public void run() {
                    try {
                        api.configure("9b17d663752843a1bfa4cc72d309339e",
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
}