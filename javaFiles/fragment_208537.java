List<String> installedApps = new ArrayList<String>();
List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);
for(int i=0;i<packs.size();i++) {
    PackageInfo p = packs.get(i);

    String appName = p.applicationInfo.loadLabel(getPackageManager()).toString();
    installedApps.add(appName);
}