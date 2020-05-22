public List<Apps> listAllApps() {
    List<Apps> apps = new ArrayList<Apps>();
    List<ApplicationInfo> appinfo = pm.getInstalledApplications(0);

    Apps app;
    i = 0;
    List<String> appnames = appNames();
    for (int j = 0; j < appinfo.size(); j++) {
        if (Config.in_array(appnames, appinfo.get(j).packageName)) {
            app = new Apps();
            app.setPackageName(appinfo.get(j).packageName);
            app.setTitle(appinfo.get(j).loadLabel(pm).toString());
            apps.add(app);
            if (appinfo.get(j).packageName.contains("gallery") ||
                appinfo.get(j).loadLabel(pm).toString().contains("gallery")) {
                    if (appinfo.get(j).name.contains("gallery")) {
                        setGalleryPackage(i, appinfo.get(j).packageName);
                    } else
                        setGalleryPackage(i, appinfo.get(j).packageName);
                    i++;
                }
            }
        }
        return apps;
    }

    public List appNames() {
        final Intent mainIntent = new Intent(Intent.ACTION_MAIN);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> packs = pm.queryIntentActivities(mainIntent, 0);

        List<String> appNames = new ArrayList<String>(packs.size());
        for (ResolveInfo ai : packs) {
            appNames.add(ai.activityInfo.packageName.toString());
        }
        return appNames;
    }