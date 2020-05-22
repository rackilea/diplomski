List<String> list = new ArrayList<String>();
PackageManager pm = getPackageManager();
List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
for (ApplicationInfo packageInfo : packages) {
    list.add(packageInfo.packageName)
}