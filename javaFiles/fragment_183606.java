public static final ACTION_SOMETHING = BuildConfig.APPLICATION_ID + ".ACTION_SOMETHING";

public void doSomething() {
    // ...

    // Show toast if app is running. Or let the app react however you please.
    LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(ACTION_SOMETHING));

    // ...
}