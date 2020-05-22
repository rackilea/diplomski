/**
 * Created by MuhammadFaisal on 8/10/2017.
 */

public class VolleySingleton {
private static final int MAX = 2 * 1024 * 1024;
private static int MAX_SERIAL_THREAD_POOL_SIZE = 10;
private static VolleySingleton mSingletonInstance = null;
private final int MAX_CACHE_SIZE = 2 * 1024 * 1024; //2 MB
Context context = null;
private ImageLoader imageLoader;
private RequestQueue volleyRequestQueue;

private VolleySingleton(Context c)
{

    RequestQueue serialRequestQueue = prepareSerialRequestQueue(c);
    serialRequestQueue.start();
    context = c;

    volleyRequestQueue = Volley.newRequestQueue(c);
    imageLoader = new ImageLoader(volleyRequestQueue, new ImageLoader.ImageCache() {
        private LruCache<String, Bitmap> mCache = new LruCache<>((int) (Runtime.getRuntime().maxMemory() / 1024 / 8));

        @Override
        public Bitmap getBitmap(String url)
        {
            return mCache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap)
        {
            mCache.put(url, bitmap);
        }
    });
}

public static VolleySingleton getInstance(Context context)
{
    if (mSingletonInstance == null)
    {
        mSingletonInstance = new VolleySingleton(context);
    }
    return mSingletonInstance;
}

public static RequestQueue prepareSerialRequestQueue(Context context)
{
    Cache cache = new DiskBasedCache(context.getCacheDir(), MAX);
    Network network = getNetwork();
    RequestQueue requestQueue;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
            && Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT)
    {
        try
        {
            if (checkGooglePlayServices(context))
                ProviderInstaller.installIfNeeded(context);
        }
        catch (GooglePlayServicesRepairableException e)
        {
            // Indicates that Google Play services is out of date, disabled, etc.
            // Prompt the user to install/update/enable Google Play services.
            GooglePlayServicesUtil.showErrorNotification(e.getConnectionStatusCode(), context);
            // Notify the SyncManager that a soft error occurred.
            //syncResult.stats.numIOExceptions++;
            return null;
        }
        catch (GooglePlayServicesNotAvailableException e)
        {
            // Indicates a non-recoverable error; the ProviderInstaller is not able
            // to install an up-to-date Provider.
            // Notify the SyncManager that a hard error occurred.
            //GooglePlayServicesUtil.showErrorNotification(e.getConnectionStatusCode(), context);
            //syncResult.stats.numAuthExceptions++;
            return null;
        }

        HttpStack stack = null;
        try
        {
            stack = new HurlStack(null, new TLSSocketFactory());
        }
        catch (KeyManagementException e)
        {
            e.printStackTrace();
            Log.d("Your Wrapper Class", "Could not create new stack for TLS v1.2");
            stack = new HurlStack();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            Log.d("Your Wrapper Class", "Could not create new stack for TLS v1.2");
            stack = new HurlStack();
        }
        requestQueue = Volley.newRequestQueue(context, stack);
        return requestQueue;
    }
    else
        return new RequestQueue(cache, network, MAX_SERIAL_THREAD_POOL_SIZE);
}

private static Network getNetwork()
{
    HttpStack stack;
    String userAgent = "volley/0";
    if (Build.VERSION.SDK_INT >= 9)
    {
        stack = new HurlStack();
    }
    else
    {
        stack = null;
        //stack = new HttpClientStack(AndroidHttpClient.newInstance(userAgent));
    }
    return new BasicNetwork(stack);
}

private static boolean checkGooglePlayServices(Context con)
{
    switch (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(con))
    {
        case ConnectionResult.SERVICE_MISSING:
            Log.d("googleError: ", Integer.toString(ConnectionResult.SERVICE_MISSING));
            //GoogleApiAvailability.getInstance().getErrorDialog(SplashScreen.this,ConnectionResult.SERVICE_MISSING,0).show();
            break;
        case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:
            Log.d("googleError: ", Integer.toString(ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED));
            //GoogleApiAvailability.getInstance().getErrorDialog(this,ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED,0).show();
            break;
        case ConnectionResult.SERVICE_DISABLED:
            Log.d("googleError: ", Integer.toString(ConnectionResult.SERVICE_DISABLED));
            //GoogleApiAvailability.getInstance().getErrorDialog(this,ConnectionResult.SERVICE_DISABLED,0).show();
            break;
    }
    return true;
}

public RequestQueue getVolleyRequestQueue()
{
    if (volleyRequestQueue == null)
    {
        // getApplicationContext() is key, it keeps you from leaking the
        // Activity or BroadcastReceiver if someone passes one in.
        volleyRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }
    return volleyRequestQueue;
}

public ImageLoader getImageLoader()
{
    return imageLoader;
}
}