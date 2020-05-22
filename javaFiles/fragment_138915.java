/**
     * startForegroundService() was introduced in O, just call startService
     * for before O.
     *
     * @param context Context to start Service from.
     * @param intent The description of the Service to start.
     *
     * @see Context#startForegeroundService()
     * @see Context#startService()
     */
    public static void startForegroundService(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            // Pre-O behavior.
            context.startService(intent);
        }
    }