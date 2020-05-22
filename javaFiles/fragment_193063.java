public static boolean isEAPSIMSupported() {
    ActivityManager manager = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
    for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
        if("org.simalliance.openmobileapi.service.SmartcardService".equals(service.service.getClassName())) {
            Log.i(WifiHelper.class, "EAP-SIM Supported");
            return true;
        }
    }
    Log.i(WifiHelper.class, "EAP-SIM not Supported");
    return false; 
}