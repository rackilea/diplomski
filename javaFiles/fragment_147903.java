public class Common {

    public static boolean isConnected(Context context) {

         ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
         NetworkInfo netinfo = cm.getActiveNetworkInfo();

              if (netinfo != null && netinfo.isConnectedOrConnecting()) {
               android.net.NetworkInfo wifi=cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
               android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        return (mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting());
    } else
        return false;
    }
}