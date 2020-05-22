StringBuffer appNameAndPermissions = new StringBuffer();
PackageManager pm = getPackageManager();
List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

for (ApplicationInfo applicationInfo : packages) {
    Log.d("test", "App: " + applicationInfo.name + " Package: " + applicationInfo.packageName);
try {
    PackageInfo packageInfo = pm.getPackageInfo(applicationInfo.packageName, PackageManager.GET_PERMISSIONS);
    appNameAndPermissions.append(packageInfo.packageName+"*******:\n");

    //Get Permissions
    String[] requestedPermissions = packageInfo.requestedPermissions;
    if(requestedPermissions != null) {
        for (int i = 0; i < requestedPermissions.length; i++) {
            Log.d("test", requestedPermissions[i]);
            appNameAndPermissions.append(requestedPermissions[i]+"\n");
        }
    appNameAndPermissions.append("\n");
} catch (NameNotFoundException e) {
    e.printStackTrace();
}