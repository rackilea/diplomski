PackageManager p = context.getPackageManager(); 
final List<PackageInfo> apps = p.getInstalledPackages(PackageManager.GET_PERMISSIONS);
for (PackageInfo pkg : apps) {
    for (String permission : pkg.requestedPermissions) {
        // Check if permission is the internet permission
    }
}