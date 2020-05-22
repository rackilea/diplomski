String apkPath = Environment.getExternalStorageDirectory().getAbsolutePath() 
                   + "/MyApp.apk";
    PackageManager pm = getPackageManager();

    PackageInfo info = pm.getPackageArchiveInfo(apkPath, 
                           PackageManager.GET_ACTIVITIES);
    //Log.i("ActivityInfo", "Package name is " + info.packageName);

    for (android.content.pm.ActivityInfo a : info.activities) {
        Log.i("ActivityInfo", a.name);
    }