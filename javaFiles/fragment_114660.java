/**
 * @author Darko.Grozdanovski
 */
public class HttpRequestStore {

    public static final String TAG = HttpRequestStore.class.getSimpleName();

    public static final String KEY_ID = "id";
    public static final String IS_SUCCESSFUL = "isSuccessful";

    private static final HashMap<Integer, RequestWrapper> map = new HashMap<Integer, RequestWrapper>();

    private final AtomicInteger counter = new AtomicInteger();
    private static Class<?> executorServiceClass = HTTPRequestExecutorService.class;

    private final Context context;
    private static HttpRequestStore instance;

    private HttpRequestStore(final Context context) {
        this.context = context;
    }

    public static HttpRequestStore getInstance(final Context context) {
        if (instance == null) {
            instance = new HttpRequestStore(context.getApplicationContext());
        }
        return instance;
    }

    public static void init(final Class<?> executorServiceClass) {
        HttpRequestStore.executorServiceClass = executorServiceClass;
    }

    public Integer addRequest(final RequestWrapper block) {
        return addRequest(counter.incrementAndGet(), block);
    }

    public Integer addRequest(final Integer id, final RequestWrapper block) {
        map.put(id, block);
        return id;
    }

    public void removeBlock(final Integer id) {
        map.remove(id);
    }

    public RequestWrapper getRequest(final Integer id) {
        return map.remove(id);
    }

    public RequestWrapper getRequest(final Intent intent) {
        final Bundle extras = intent.getExtras();
        if (extras == null || extras.containsKey(KEY_ID) == false) {
            throw new RuntimeException("Intent Must be Filled with ID of the block");
        }
        final int id = extras.getInt(KEY_ID);
        return getRequest(id);
    }

    public Integer launchServiceIntent(final HttpRequest block) {
        return launchServiceIntent(block, null);
    }

    public Integer launchServiceIntent(final HttpRequest block, RequestOptions options) {
        if (executorServiceClass == null) {
            throw new RuntimeException("Initialize the Executor service class in a class extending application");
        }
        if (isServiceAvailable() == false) {
            throw new RuntimeException("Declare the " + executorServiceClass.getSimpleName() + " in your manifest");
        }
        final Intent service = new Intent(context, executorServiceClass);
        final RequestWrapper wrapper = new RequestWrapper(block, options);
        final Integer requestId = addRequest(wrapper);
        service.putExtra(KEY_ID, requestId);
        context.startService(service);
        return requestId;
    }

    public boolean isServiceAvailable() {
        final PackageManager packageManager = context.getPackageManager();
        final Intent intent = new Intent(context, executorServiceClass);
        final List<ResolveInfo> resolveInfo = packageManager.queryIntentServices(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        if (resolveInfo.size() > 0) {
            return true;
        }
        return false;
    }

}