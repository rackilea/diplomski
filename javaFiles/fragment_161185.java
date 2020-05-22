if (Build.VERSION.SDK_INT >= 23) {
    String packageName = context.getPackageName();
    PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
    if (! pm.isIgnoringBatteryOptimizations(packageName)) {
        //reguest that Doze mode be disabled
        Intent intent = new Intent();
        intent.setAction(
            Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
        intent.setData(Uri.parse("package:" + packageName));

        context.startActivity(intent);
    }

}