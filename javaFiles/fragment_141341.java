public class AndroidProjectActivity extends Activity {
    private Handler mHandler;
    private TextView mTextView;
    private Runnable mCountUpdater = new Runnable() {
        private int mCount = 0;
        run() {
           if(mCount > 9)
               return;
           mTextView.setText(String.valueOF(mCount+48));
           mCount++;
           // Reschedule ourselves.
           mHandler.postDelayed(this, 5000);
        }
    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // Cleaner to load a view from a layout..
        TextView tv = new TextView(this);
        setContentView(tv);
        mTextView = tv;
        // Create handler on UI thread.
        mHandler = new Handler();
        mHandler.post(mCountUpdater);
    }
}