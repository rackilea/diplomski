public class B extends Thread {
    TextView inputtext;
    Activity activity;

    public B(Activity activity, TextView x) {
        inputtext = x;
        this.activity = activity;
    }

    public void run() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                inputtext.setText("hero");
            }
        });
    }
}