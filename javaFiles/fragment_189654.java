public static boolean isConnectingToInternet(Context context) {

    ConnectivityManager cm =
            (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

    return activeNetwork != null &&
            activeNetwork.isConnectedOrConnecting();
}