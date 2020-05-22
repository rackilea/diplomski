PackageManager packageManager = getPackageManager();
if (intent.resolveActivity(packageManager) != null) {
    startActivity(intent);
} else {
     Log.d(TAG, "Cannot handle this intent");
}