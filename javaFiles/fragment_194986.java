public boolean isConnectingToInternetAccess(){
        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
          if (connectivity != null)
          {
              NetworkInfo[] info = connectivity.getAllNetworkInfo();
              if (info != null)
                  for (int i = 0; i < info.length; i++)
                      if (info[i].getState() == NetworkInfo.State.CONNECTED)
                      {
                       try {
                             Process p1 = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.com");
                             int returnVal = p1.waitFor();
                             boolean reachable = (returnVal==0);
                             return reachable;
                         } catch (Exception e) {
                             // TODO Auto-generated catch block
                             e.printStackTrace();
                         }
                       return true;
                      }
          }
          return false;
    }