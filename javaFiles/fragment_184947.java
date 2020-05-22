class PermissionsChecker {

   private final Context context;

   PermissionsChecker(Context context) {
       this.context = context;
   }

    public boolean isLocationPermissionGranted() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return false;
        if (context.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            return false;
        return true;
   }
}