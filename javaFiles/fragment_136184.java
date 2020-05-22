private int getCurrentVersionCode() {
    try {
        return getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
    } catch (NameNotFoundException e) {
        e.printStackTrace();
    }
    return -1;
}