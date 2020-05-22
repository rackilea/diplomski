public class MyGcmPushReceiver extends GcmListenerService {

    /**
     * Called when message is received.
     * @param from   SenderID of the sender.
     * @param bundle Data bundle containing message data as key/value pairs.
     *               For Set of keys use data.keySet().
     */
    @Override
    public void onMessageReceived(String from, Bundle bundle) {
        // Check here whether the app is in background or running.
        if(isAppIsInBackground(getApplicationContext())) {
            // Show the notification
        } else {
            // Don't show notification
        }
    }

        /**
        * Method checks if the app is in background or not
        */
        private boolean isAppIsInBackground(Context context) {
            boolean isInBackground = true;

            ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
                List<ActivityManager.RunningAppProcessInfo> runningProcesses = am.getRunningAppProcesses();
                for (ActivityManager.RunningAppProcessInfo processInfo : runningProcesses) {
                    if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                        for (String activeProcess : processInfo.pkgList) {
                            if (activeProcess.equals(context.getPackageName())) {
                                isInBackground = false;
                            }
                        }
                    }
                }
            }
            else
            {
                List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
                ComponentName componentInfo = taskInfo.get(0).topActivity;
                if (componentInfo.getPackageName().equals(context.getPackageName())) {
                    isInBackground = false;
                }
            }
            return isInBackground;
        }
}