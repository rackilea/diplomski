public class Controller extends Application {
    private static Controller instance;
    private static DefaultHttpClient client;
    private static ProfileModel profile;
    private static Set<ControllerUpdateListener> updateListeners = new HashSet<ControllerUpdateListener>();

    //...

    public static void addListener(ControllerUpdateListener listener)
    {
        updateListeners.add(listener);
    }

    public static interface ControllerUpdateListener {
        void onControllerUpdate(ProfileModel model);
    }
}