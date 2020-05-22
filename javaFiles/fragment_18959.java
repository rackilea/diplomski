Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
List<ResolveInfo> pkgAppsList = getPackageManager().queryIntentActivities(mainIntent, 0);
    for (int i = 0; i < pkgAppsList.size(); i++) {
          Log.e("Activity package", pkgAppsList.get(i).activityInfo.name);
     }