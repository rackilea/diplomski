public class MainActivityChats extends AppCompatActivity implements Application.ActivityLifecycleCallbacks 
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplication().registerActivityLifecycleCallbacks(this);
    }

    public void onActivityResumed(Activity activity)
    {
        if(msg_updater != null)
        {
            msg_updater.set_app_is_active(true);
        }

    }
    public void onActivityPaused(Activity activity)
    {
        if(msg_updater != null)
        {
            msg_updater.set_app_is_active(false);
        }
    }

    public void onActivityStopped(Activity activity) {}
    public void onActivityCreated(Activity activity, Bundle bundle) {}
    public void onActivityStarted(Activity activity) {}
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {}
    public void onActivityDestroyed(Activity activity) {}
}