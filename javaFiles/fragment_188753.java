try {
        Context context = InstrumentationRegistry.getContext();
        PackageManager pm = context.getPackageManager();
        PackageInfo pInfo = pm.getPackageInfo("com.google.android.apps.photos", 0);
        String version = pInfo.versionName;
        Log.d(TAG, "checkVersion.DEBUG: App version: "+version);
    } catch (PackageManager.NameNotFoundException e) {
        e.printStackTrace();
    }