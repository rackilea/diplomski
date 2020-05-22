public class CheckInternetConnection extends BroadcastReceiver {


        @Override
        public void onReceive(final Context arg0, Intent arg1) {

    if (haveNetworkConnection(arg0)) {
    //TODO iF INTERNET IS CONNECTED 
    }else{
    //TODO iF INTERNET IS DISCONNECTED 


    }
}
        private boolean haveNetworkConnection() {
            boolean haveConnectedWifi = false;
            boolean haveConnectedMobile = false;

            try {
                android.net.ConnectivityManager cm = (android.net.ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
                android.net.NetworkInfo[] netInfo = cm.getAllNetworkInfo();
                for (android.net.NetworkInfo ni : netInfo) {
                    if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                        if (ni.isConnected())
                            haveConnectedWifi = true;
                    if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                        if (ni.isConnected())
                            haveConnectedMobile = true;
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return haveConnectedWifi || haveConnectedMobile;
        }
}