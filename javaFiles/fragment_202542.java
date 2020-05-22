public boolean isOnline() {

        ConnectivityManager connMgr = (ConnectivityManager) 
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI); 

        boolean isWifiConn = networkInfo.isConnected();

        networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        boolean isMobileConn = networkInfo.isConnected();

        if (isWifiConn)
            return true;
        else
        {   
            if (isMobileConn)
                return true;
            else
                return false;
        }
    }