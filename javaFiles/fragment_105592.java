public class MyApplication extends MultiDexApplication implements LifecycleObserver

@Override
public void onCreate() {
    super.onCreate();

    ProcessLifecycleOwner.get().getLifecycle().addObserver(this);

}