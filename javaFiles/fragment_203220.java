public class MainActivity extends Activity implements Runnable {
private static final String TAG= MainActivity.class.getName();
private long lastUsed;
private int period;
private boolean stop;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    period = 10000;
    stop=false;
    touch();
    Thread currentThread = new Thread(this);
    currentThread.start();
    Toast.makeText(getApplicationContext(), "Start", Toast.LENGTH_SHORT).show();
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.activity_main, menu);
    return true;
}

@Override
public void onUserInteraction()
{
    super.onUserInteraction();
    touch();
    Log.d(TAG, "User interaction to "+this.toString());
}

public synchronized void touch()
{
    lastUsed=System.currentTimeMillis();
    Toast.makeText(getApplicationContext(), "touch", Toast.LENGTH_SHORT).show();
}

public void moveIntent() {
    Intent intent = new Intent(this, AfterIdle.class);
    startActivity(intent);
}

public void validate(View view) {
    switch (view.getId()) {
        case R.id.button1 :
            Intent intent = new Intent(this, AfterIdle.class);
            startActivity(intent);
            break;
    }
}

@Override
public void run() {
    // TODO Auto-generated method stub
    long idle;

    while (!stop) {
        idle=System.currentTimeMillis()-lastUsed;
        try
        {
            Thread.sleep(5000); //check every 5 seconds
        }
        catch (InterruptedException e)
        {
            Log.d(TAG, "Waiter interrupted!");
        }
        if (idle > period) {
            idle = 0;
            stop = true;
        }
    }
    handler.sendEmptyMessage(0);
}

public Handler handler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        moveIntent();
    }
};}