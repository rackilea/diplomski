/**
     * Function for check network connectivity after every 5 seconds
     */
    private void checkNetworkConnectivity() {
        // handler will run after 5 seconds
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                         ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                                         NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                                          if (mWifi.isConnected()){
                                              checkNetworkConnectivity();
                                          }else {
                                              // display alert (notification)
                                          }

                                      }
                                  },5000
        );
    }