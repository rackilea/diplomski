public class VolleyApplication extends Application {
    private static final String TAG = VolleyNetworkTask.class.getSimpleName();
    private static VolleyNetworkTask sInstance;
    private static RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        mRequestQueue = Volley.newRequestQueue(this);
        sInstance = this;
    }

    public synchronized static VolleyNetworkTask getInstance() {
        return sInstance;
    }

    public static RequestQueue getRequestQueue() {
        return mRequestQueue;
    }
}