public class MainActivity extends Activity {
public static final String ACTION_TASK_COMPLETED = "com.sample.project.action.ACTION_TASK_COMPLETED";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}

private class DoTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... params) {
        // please wait. I am doing work
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        // yay... work completed...
        Intent intent = new Intent(ACTION_TASK_COMPLETED);
        LocalBroadcastManager.getInstance(MainActivity.this).sendBroadcast(intent);
    }
  }
}

public class SecondActivity extends Activity {
private TaskReceiver taskReceiver;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    IntentFilter intentFilter = new IntentFilter(MainActivity.ACTION_TASK_COMPLETED);
    taskReceiver = new TaskReceiver();
    LocalBroadcastManager.getInstance(this).registerReceiver(taskReceiver, intentFilter);
}

@Override
protected void onDestroy() {
    super.onDestroy();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(taskReceiver);
}

private void onUploadImage() {
    // uploading completed... 
}

private class TaskReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        onUploadImage();
    }
}
}