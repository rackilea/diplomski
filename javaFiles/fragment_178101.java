public class BoundService extends Service {
    private final BackgroundBinder _binder = new BackgroundBinder();

    public IBinder onBind(Intent intent) {
        return _binder;
    }


    public class BackgroundBinder extends Binder {
        public BoundService getService() {
            return BoundService.this;
        }
    }
}