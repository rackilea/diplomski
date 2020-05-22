@SimpleFunction(description = "Returns the version name of the app")
  public String VersionName() {
    Log.d(LOG_TAG, "VersionName");
    try {
      PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
      String version = pInfo.versionName;
      return version;
    } catch (NameNotFoundException e) {
      Log.e(LOG_TAG, e.getMessage());
      e.printStackTrace();
      return "";
    }
  }