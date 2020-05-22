boolean exit = false;
 while(!exit)
 { 
      List<RunningTaskInfo> taskInfo = am.getRunningTasks(1);
      ComponentName componentInfo = taskInfo.get(0).topActivity;
     if(componentInfo.getPackageName().equals("Your package name"))
     {
      //Do your work here
      exit = true;
     }
 }