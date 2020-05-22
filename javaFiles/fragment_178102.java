public class BoundServiceUser extends Activity {
    private BoundService _boundService;
    private boolean _isBound;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    private void init() {
        //The background Service initialization settings
        Intent intent = new Intent(this, BoundService.class);
        bindService(intent, _serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (_isBound)
            unbindService(_serviceConnection);
    }

    private ServiceConnection _serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            BoundService.BackgroundBinder binder = (BoundService.BackgroundBinder)service;
            _boundService = binder.getService();
            _isBound = true;

            //Any other setup you want to call. ex.
            //_boundService.methodName();
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            _isBound = false;
        }
    };
}