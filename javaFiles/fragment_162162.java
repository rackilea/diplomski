public static String getUniqueIMEIId(Context context) {
    try {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {          
            return "";
        }
        String imei = telephonyManager.getDeviceId();
        Log.e("imei", "=" + imei);
        if (imei != null && !imei.isEmpty()) {
            return imei;
        } else {
            return android.os.Build.SERIAL;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "not_found";
}