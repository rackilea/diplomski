private boolean checkIntent(Intent intent) {
    PackageManager packageManager = getPackageManager();
    List activities =     packageManager.queryIntentActivities(intent,
        PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;

        return isIntentSafe;
}