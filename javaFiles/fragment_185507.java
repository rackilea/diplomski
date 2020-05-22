public class SplashScreen extends Activity{

private SplashHandler mSplashHandler = new SplashHandler();


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.splash);

    mSplashHandler.sendEmptyMessageDelayed(SplashHandler.TIMER_EXPIRED, 5);
}




class SplashHandler extends Handler {
    static final int TIMER_EXPIRED = 100;
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
        case TIMER_EXPIRED:
            Intent in = new Intent(SplashScreen.this, nextActivity.class);
            startActivity(in);
            finish();
            break;

        default:
            break;
        }
    }
}

@Override
protected void onDestroy() {
    mSplashHandler = null;
    super.onDestroy();
}
}