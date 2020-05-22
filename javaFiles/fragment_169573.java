/**
  * return false if in settings "Not optimized" and true if "Optimizing battery use"
  */
private boolean checkBatteryOptimized() {
final PowerManager pwrm = (PowerManager) getSystemService(Context.POWER_SERVICE);
try {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        return !pwrm.isIgnoringBatteryOptimizations(getBaseContext().getPackageName());
    }
}catch (Exception ignored){}
return false;
}

private void startBatteryOptimizeDialog(){
 try {
Intent intent = new Intent(android.provider.Settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
intent.setData(Uri.parse("package:PUT_YOUR_PACKAGE_NAME_HERE"));
startActivity(intent);

 } catch (ActivityNotFoundException e) {
   e.printStackTrace();
}
}