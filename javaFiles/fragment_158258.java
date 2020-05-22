public class MyService extends Service {
    Handler handler;
    Runnable test;
    public MyService() {
        handler = new Handler();
        test = new Runnable() {
            @Override
            public void run() {
                Log.d("foo", "bar");
                handler.postDelayed(test, 100); //100 ms you should do it 4000
            }
        };

        handler.postDelayed(test, 0);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}