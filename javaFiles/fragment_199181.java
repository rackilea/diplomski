public static void getApkPackage(PackageManager pm, String pathToApk) {
    String fullPath = pathToApk;
    PackageInfo info = pm.getPackageArchiveInfo(fullPath, 0);
    Log.i("Package", "PackageName: " + info.packageName + ", VersionName : " + info.versionName );

}