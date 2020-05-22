if(isConnectedToInternet())
   {
      // Run AsyncTask
    }
   else
   {
      // Here I've been added intent to open up data settings
   Intent intent=new Intent(Settings.ACTION_MAIN);
   ComponentName cName = new ComponentName("com.android.phone","com.android.phone.NetworkSetting");
   intent.setComponent(cName); 
    }