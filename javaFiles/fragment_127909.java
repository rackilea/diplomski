private boolean isMyServiceRunning() {
    ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
    for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
        if ("your.service.classname".equals(service.service.getClassName())) {
            return false;
        }
    }
    return true;
}

if(isMyServiceRunning()) {
    stopService(new Intent(ServiceTest.this,MailService.class));
}