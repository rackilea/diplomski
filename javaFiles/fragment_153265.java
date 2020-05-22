public static String getUniqueIMEIId(Context context) {
    try {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
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