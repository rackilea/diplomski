public class AppController extends Application {
public static final String TAG = AppController.class.getSimpleName();
private RequestQueue mRequestQueue;
private static AppController mInstance;
@Override
public void onCreate() {
    super.onCreate();
    mInstance = this;
}

  public static synchronized AppController getInstance() {
    return mInstance;
}

public RequestQueue getRequestQueue() {
    if (mRequestQueue == null) {
        mRequestQueue = Volley.newRequestQueue(getApplicationContext());
    }
    return mRequestQueue;
}

public <T> void addToRequestQueue(Request<T> req, String tag) {
    req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
    getRequestQueue().add(req);
}
 }