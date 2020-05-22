public class LooperThread extends Thread {

    @Override
    public void run() {
        Looper.prepare();

        Handler mHandler = new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                 // handle your message here
            }
        };
        Looper.loop();
    }
}