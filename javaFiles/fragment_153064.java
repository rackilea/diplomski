List<PackageInfo> list = pm.getInstalledPackages(PackageManager.GET_ACTIVITIES);

for (PackageInfo pInfo : list) {        
    if (pInfo.installLocation != PackageInfo.INSTALL_LOCATION_INTERNAL_ONLY) {
        // then it can be moved to the SD card
    } else {
        // otherwise, it can only be installed on internal storage
    }
}