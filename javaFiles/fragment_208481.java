@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_splash);

    this.runOnUiThread(new Runnable()
    {
        @Override
        public void run()
        {
            new AsyncInitLooperTask().execute();
        }
    });
     }

public class AsyncInitLooperTask extends AsyncTask<Void, Void, Void>
{
    @Override
    protected Void doInBackground(Void... params)
    {
        return null;
    }
}