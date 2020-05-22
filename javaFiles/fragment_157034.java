public class CheckConnectivity {
    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if( cm == null )
            return false;
        NetworkInfo info = cm.getActiveNetworkInfo();
        if( info == null )
            return false;
        return info.isConnectedOrConnecting();
    }
}