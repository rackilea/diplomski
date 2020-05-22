List<PackageInfo> pInfos = getPackageManager().getInstalledPackages(PackageManager.GET_ACTIVITIES);
for (PackageInfo pInfo : pInfos) {
  ActivityInfo[] aInfos = pInfo.activities;
  if (aInfos != null) {
    for (ActivityInfo activityInfo : aInfos) {
      Log.i("ACT", activityInfo.name);
      // do whatever else you like... 
    }
  }
}