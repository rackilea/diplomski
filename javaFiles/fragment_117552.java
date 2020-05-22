ActivityManager mgr = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
     List< ActivityManager.RunningTaskInfo > taskInfo = mgr.getRunningTasks(1); 
     Log.d("topActivity", "Current Running Activity ::"
             + taskInfo.get(0).topActivity.getClassName());

     ComponentName component = taskInfo.get(0).topActivity;
     String packageName = component.getPackageName();
     Toast.makeText(getApplicationContext(), packageName , Toast.LENGTH_SHORT).show();