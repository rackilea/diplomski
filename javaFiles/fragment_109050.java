PackageManager pm = getPackageManager();
List<ApplicationInfo> appList = pm.getInstalledApplications(
        PackageManager.GET_META_DATA);

int count = appList.size();
String[] appLabels = new String[count];
String[] pkgNames = new String[count];

for (int i = 0; i < count ; i++) {
    ApplicationInfo app = appList.get(i);
    appLabels[i] = pm.getApplicationLabel(app).toString();
    pkgNames[i] = app.packageName;
}

prefList.setEntries(appLabels);
prefList.setEntryValues(pkgNames);