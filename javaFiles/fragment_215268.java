public class ObserverService extends Service {

    private Looper mLooper;

    private void onDataChanged() {
        // do whatever you need.
        // This is executed in a background thread.
    }

    @Override
    public void onCreate() {
        HandlerThread ht = new HandlerThread("ObserverService");
        ht.start();
        mLooper = ht.getLooper();
        final Handler handler = new Handler(mLooper) {
            @Override
            public void handleMessage(Message msg) {
                // executed in background HandlerThread
                onDataChanged();
            }
        };
        Observer observer = new Observer() {
            @Override
            public void update(Observable observable, Object data) {
                // this is executed in whatever thread notifies
                // enqueue max 1 messages.
                handler.removeMessages(1234);
                handler.sendEmptyMessage(1234);
            }
        };
        // register observer that send message to background thread.
        Data.getInstance().addObserver(observer);
    }

    @Override
    public void onDestroy() {
        mLooper.quit();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}