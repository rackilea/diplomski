//define this variable above onReceive() with default value as false;
boolean appRunningInBack=false;

ActivityManager am = (ActivityManager) mContext.getSystemService(Activity.ACTIVITY_SERVICE);
String packageName = am.getRunningTasks(1).get(0).topActivity.getPackageName();

if(packageName.equalIgnoreCase("your app package name") || appRunningInBack)
{    
    appRunningInBack=true;
    abortBroadCast();
} else {

}