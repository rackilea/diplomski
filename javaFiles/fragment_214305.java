SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
int appLaunchCount = pref.getInt("appLaunchCount",-1);
    if(appLaunchCount==10){
        // code to show dialog
        // reset
        appLaunchCount=0;
    } else {
        // increment count
        appLaunchCount = appLaunchCount+1;
    }
    SharedPreferences.Editor editor = pref.edit();
    editor.putInt("appLaunchCount", appLaunchCount);
    editor.apply();