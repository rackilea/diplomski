public class DelayedExitActivity extends Activity {

    private static final String LOG_TAG = "DelayedExit";
    private final  Runnable longOperation = new Runnable(){
        @Override
        public void run() {
            for (int i=0 ; i < 50; i++){
                Log.d(LOG_TAG, "Iteration "+i);
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    };
    private Thread longThread ;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void onDestroy() {
        if(longThread == null){
            longThread = new Thread(longOperation);
        }
        longThread.start();
        super.onDestroy();
    }
}