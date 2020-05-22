public class countdown_timer extends CountDownTimer {
    TextView textView;
    @Override
    public void onTick(long millisInFuture) {
        long sec = millisInFuture/1000;
            if(millisInFuture <= 0) {
                Log.v("status", "done");

        } else {
            Log.v("status", Long.toString(sec) + " seconds remain and timer has stopped!");
        }
    }

    @Override
    public void onFinish() {
        if(textView != null){
            // change text in your textview
        }
    }



    public countdown_timer(long pMillisInFuture, long pCountDownInterval) {
        super(pMillisInFuture, pCountDownInterval);

    }
    public countdown_timer(TextView textView, long pMillisInFuture, long pCountDownInterval) {
        super(pMillisInFuture, pCountDownInterval);
        this.textView = textView;




    }






}