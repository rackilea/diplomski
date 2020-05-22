public class BackendCheck implements Callable<Boolean>
{
    public interface BackendCheckListener
    {
        public void onServerIsDown();
    }

    private static final String TAG = BackendCheck.class.getSimpleName();

    // Thread sleep time
    private static final int THREAD_SLEEP = 5000;

    // Number of attempts to call an API in order to get response
    private static final int MAX_ATTEMPT = 3;

    // Current attempt
    private int counter = 0;

    // The url that should be used in order to get server response
    private String mTestUrl;

    // App mContext
    private Context mContext;

    // Server status
    private boolean mIsServerWorking = false;

    // Server listener
    private BackendCheckListener mListener;


    public BackendCheck(Context context)
    {
        this(context, "");
    }

    public BackendCheck(Context context, String url)
    {
        this.mTestUrl = url;
        this.mContext = context;
    }

    public void setServerListener (BackendCheckListener listener)
    {
        this.mListener = listener;
    }

    public void start()
    {
        Thread thread = new Thread()
        {
            @Override
            public void run() {
                boolean isServerWorking = execute();
                if(!isServerWorking)
                {
                    mListener.onServerIsDown();
                }
            }
        };

        thread.start();
    }

    private boolean execute()
    {
        // Check #mTestUrl and use Feature API if this variable is empty
        if (TextUtils.isEmpty(mTestUrl))
        {
            mTestUrl = PassengerConstants.URL_BASE + mContext.getResources()
                    .getString(R.string.uri_feature_payments);
        }

        // Get ExecutorService from Executors utility class
        ExecutorService executor = Executors.newFixedThreadPool(1);

        do
        {
            // Increment counter
            counter++;

            // Submit Callable tasks to be executed by thread pool
            Future<Boolean> future = executor.submit(this);

            try
            {
                // Skip sleeping in first attempt
               if(counter > 1)
                {
                    // Sleep thread for a few seconds
                    Thread.sleep(THREAD_SLEEP);
                }

                // Break Do-While loop if server responded to request (there is no error)
                if (!future.get())
                {
                    mIsServerWorking = true;
                    break;
                }
            }
            catch (InterruptedException e)
            {
                Logger.error(TAG, e.getMessage());
            }
            catch (ExecutionException e)
            {
                Logger.error(TAG, e.getMessage());
            }

        } while (counter < MAX_ATTEMPT);

        // Try to shut down the executor service now
        try
        {
            executor.shutdown();
            executor.awaitTermination(THREAD_SLEEP, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException e)
        {
            Logger.error(TAG, e.getMessage());
        }

        // Return server status
        return mIsServerWorking;
    }

    @Override
    public Boolean call() throws Exception
    {
        try
        {
            HttpClient client = new DefaultHttpClient();
            HttpGet get = new HttpGet(mTestUrl);
            Logger.debug(TAG, "Attempt (" + counter + "), try to check => " + mTestUrl);

            HttpResponse httpResponse = client.execute(get);
            int connectionStatusCode = httpResponse.getStatusLine().getStatusCode();
            Logger.debug(TAG,
                    "Connection code: " + connectionStatusCode + " for Attempt (" + counter
                            + ") of request: " + mTestUrl);

            if (isServerError(connectionStatusCode))
            {
                return true;
            }
        }
        catch (IllegalArgumentException e)
        {
            Logger.error(TAG, e.getMessage());
        }
        catch (Exception e)
        {
            Logger.error(TAG, e.getMessage());
        }

        return false;
    }

    /**
     * Server status checker.
     *
     * @param statusCode status code of HTTP request
     * @return True if connection code is 5xx, False otherwise.
     */
    private static boolean isServerError(int statusCode)
    {
        return (statusCode >= HttpURLConnection.HTTP_INTERNAL_ERROR);
    }
}