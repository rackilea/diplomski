ConnectivityManager conMan = (ConnectivityManager)  getSystemService(Context.CONNECTIVITY_SERVICE);

//mobile
State mobile = conMan.getNetworkInfo(0).getState();

//wifi
State wifi = conMan.getNetworkInfo(1).getState();