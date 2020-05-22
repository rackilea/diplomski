public class DialogTest extends Dialog {

    Timer timer;
    double countup = 0;
    double initial_time = 0;

    public DialogTest(Context context){
        super(context);

    }


    @Override
    protected void onStart() {
        super.onStart();

        startUpCounting();
    }

    @Override
    protected void onStop() {
        Log.e("b", "timer stopped");
        if(timer != null){
            timer.cancel();
            timer = null;
        }

        super.onStop();
    }

    public void startUpCounting() {
        delay_for_student.setText("Delay in Arrival");
        rootView.invalidate();
        Log.e("b", "timer started");
        if(timer != null){
            timer.cancel();
            timer = null;
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                countup = 0.0 + initial_time;
                if (countup == 0.0) {
                    onTimeHandler.obtainMessage(1).sendToTarget();
                } else {
                    mHandler.obtainMessage(1).sendToTarget();
                }
                initial_time = initial_time + 0.5;
            }
        }, 0, 1000);
    }



    public Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            Log.e("b", "timer: " + countup);
            delay_time.setText(String.valueOf(countup) + "min");
            rootView.invalidate();
        }
    };

    public Handler onTimeHandler = new Handler() {
        public void handleMessage(Message msg) {
            Log.e("b", "timer ---");
            delay_time.setText("-");
            rootView.invalidate();
        }
    };
}