PackageManager pm=getPackageManager();
Intent main=new Intent(Intent.ACTION_MAIN, null);

main.addCategory(Intent.CATEGORY_LAUNCHER);

List<ResolveInfo> launchables=pm.queryIntentActivities(main, 0);