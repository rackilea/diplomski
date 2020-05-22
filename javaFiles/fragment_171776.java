class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        MyTimers timer = new MyTimers();
        timer.sendEmptyMessage(MyTimers.TIMER_1);
        timer.sendEmptyMessage(MyTimers.TIMER_2);

    }


    public static class MyTimers extends Handler
    {

        public static final int TIMER_1 = 0;
        public static final int TIMER_2 = 1;

        @Override
        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {
                case TIMER_1:
                    // Do something etc.
                    Log.d("TimerExample", "Timer 1");
                    sendEmptyMessageDelayed(TIMER_1, 1000);
                    break;
                case TIMER_2:
                    // Do another time update etc..
                    Log.d("TimerExample", "Timer 2");
                    sendEmptyMessageDelayed(TIMER_2, 1000);
                    break;
                default:
                    removeMessages(TIMER_1);
                    removeMessages(TIMER_2);
                    break;
            }
        }
    }
}