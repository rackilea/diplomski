int code = context.getPackageManager().checkPermission(
    android.Manifest.permission.WRITE_EXTERNAL_STORAGE, 
    context.getPackageName());
if (code == PackageManager.PERMISSION_GRANTED) {
   // todo create directory
}