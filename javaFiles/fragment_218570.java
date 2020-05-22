static boolean mWasError = false;
static String mErrorMessage = "";

static
{
    try
    {
        System.loadLibrary("MyApplication");
    }
    catch(java.lang.UnsatisfiedLinkError e)
    {
        if(e.getMessage().contains("libOpenCL"))
        {
            Log.e( TAG, "This device does not support OpenCL" );
            mWasError = true;
            mErrorMessage = "This device does not support OpenCL";
        }
        else
        {
            throw e;
        }
    }
}


@Override
protected void onCreate( Bundle savedInstanceState )
{
    if(mWasError)
    {
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(getApplicationContext(), mErrorMessage, Toast.LENGTH_SHORT).show();
                Looper.loop();

            }
        }.start();

        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
        }
    }

    // Will crash here if there was an error
    super.onCreate(savedInstanceState);