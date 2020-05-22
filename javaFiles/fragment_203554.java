public class MainActivity extends Activity {
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTextView = (TextView) findViewById(R.id.title);
        MyAsyncTask mMyAsyncTask = new MyAsyncTask();
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
            mMyAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {    
            mMyAsyncTask.execute();
        }
    }
    // Getter method for TextView.
    public static TextView getTextView() {
        return MainActivity.mTextView;
    }
    // Setter method for TextView.
    public static void setTextView(TextView textView) {
        MainActivity.mTextView = textView;
    }
}

public class MyAsyncTask extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... params) {
        String result = MyClass.getResultFromRss();
        return result;
    }
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (result != null && MainActivity.getTextView() != null) {
            MainActivity.getTextView().setText(result);
        }
    }
}

public class MyClass {
    public static String getResultFromRss() {
        // Add your OpenHttpConnection method here.
        String result = <Result_from_OpenHttpConnection_method>;
        return result;
    }
}