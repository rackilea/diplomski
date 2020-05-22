public class MyActivity extends Activity {
    private Handler mHandler = new Handler();

    ...

    private void doSomeWorkInBackground() {
        new Thread() {
            public void run() {
                // do slow work, this may be blocking
                mHandler.post(new Runnable() {
                    public void run() {
                        // this code will run on main thread, 
                        // updating your UI or whatever you need. 
                        // Hence, code here must NOT be blocking.
                    }
                });
            }
        }.start();

        // This code will be executed immediately on the main thread, and main thread will not be blocked
    }