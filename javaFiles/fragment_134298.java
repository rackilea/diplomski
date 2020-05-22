public class Application extends ContextWrapper implements ComponentCallbacks2 {
    ...
    public interface ActivityLifecycleCallbacks {
        /**
         * Called when the Activity calls {@link Activity#onCreate super.onCreate()}.
         */
        void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState);

        ...
    }
    ...
}