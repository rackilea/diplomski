public class TaskChecker{
    public static String getForegroundApplication(Context context){
        ActivityManager am=(ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
        RunningTaskInfo foreground=am.getRunningTasks(1).get(0);
        return foreground.topActivity.getPackageName();
    }
}