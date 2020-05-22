ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    //should check null because in airplane mode it will be null
    NetworkCapabilities nc = cm.getNetworkCapabilities(cm.getActiveNetwork());
    int downSpeed = nc.getLinkDownstreamBandwidthKbps();
    int upSpeed = nc.getLinkUpstreamBandwidthKbps();