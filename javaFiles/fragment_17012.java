public boolean isNetworkConnected(Context context)
{
    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo ni = cm.getActiveNetworkInfo();
    if (ni == null) {
        // There are no active networks.
        return false;
    } else
        return true;
}