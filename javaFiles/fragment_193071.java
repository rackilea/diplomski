public class FileObserverActivity extends Activity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tv = (TextView) findViewById(R.id.textView1);
        tv.setText("new world");
        MyFileObserver myFileObserver = new MyFileObserver("/sdcard/", this);
        myFileObserver.startWatching();
    }

    String mySTR = "";
    TextView tv ;

    public void event(String absolutePath,String path,int event)
    {
        runOnUiThread(action);
    }

    private Runnable action = new Runnable() {
        @Override
        public void run() {
            mySTR = absolutePath+path+"\t"+event;
            tv.setText(mySTR);
        }
    };
}

public class MyFileObserver extends FileObserver 
{
    public String absolutePath;
    FileObserverActivity fileobserveractivity;

    public MyFileObserver(String path,FileObserverActivity foa) 
    {
        super(path, FileObserver.ALL_EVENTS);
        absolutePath = path;
        fileobserveractivity = foa;
    }

    @Override
    public void onEvent(int event, String path) 
    {
        if (path == null) 
        {
            return;
        }
        else if(event!=0)
        {
            fileobserveractivity.event(absolutePath, path, event);
        }
        else
        {
            return;
        }
    }
}