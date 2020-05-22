public static boolean isDeviceOnline(Context context) {

    ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
    boolean isOnline = (networkInfo != null && networkInfo.isConnected());
    if(!isOnline)
        Toast.makeText(context, " No internet Connection ", Toast.LENGTH_SHORT).show();

    return isOnline;
}