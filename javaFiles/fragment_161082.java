private boolean isPackageInstalled(String packagename, PackageManager packageManager) {
try {
    packageManager.getPackageInfo(packagename, 0);
    return true;
} catch (NameNotFoundException e) {
    return false;
}
}