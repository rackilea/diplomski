public static ArrayList<ResolveInfo> getInstalledApplications(Context c) {
    Intent intent = new Intent(Intent.ACTION_MAIN);
    intent.addCategory(Intent.CATEGORY_LAUNCHER);
    ArrayList<ResolveInfo> applist = c.getPackageManager().queryIntentActivities(intent, PackageManager.GET_ACTIVITIES);
    Collections.sort(applist, new Comparator<ResolveInfo>(){
          public int compare(ResolveInfo emp1, ResolveInfo emp2) {
            return emp1.loadLabel(pm).toString().compareToIgnoreCase(emp2.loadLabel(pm).toString());
          }
        });
    return applist;