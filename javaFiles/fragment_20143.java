ActivityManager mngr = (ActivityManager) getSystemService( ACTIVITY_SERVICE );
List<ActivityManager.RunningTaskInfo> taskList = mngr.getRunningTasks(10);
if(taskList.get(0).numActivities == 1 &&
        !taskList.get(0).topActivity.getClassName().equals(MainActivity.getClass().getName()))
{
    Log.i(TAG, "Need to launch MainActivity");
    Intent mainActivityIntent = new Intent(this, MainActivity.class);
    startActivity(mainActivityIntent);
}