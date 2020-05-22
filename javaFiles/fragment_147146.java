Intent vlcIntent = new Intent(Intent.ACTION_VIEW);
vlcIntent.setPackage("org.videolan.vlc");

PackageManager packageManager = getPackageManager();
    List activities = packageManager.queryIntentActivities(vlcIntent,
            PackageManager.MATCH_DEFAULT_ONLY);
    boolean isIntentSafe = activities.size() > 0;

if (isIntentSafe){    
    startActivity(vlcIntent);
} else {
    Intent marketIntent = new Intent(Intent.ACTION_VIEW);
    marketIntent.setData(Uri.parse("market://details?id=org.videolan.vlc"));
    startActivity(marketIntent);
}