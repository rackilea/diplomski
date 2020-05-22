public boolean hasConnectivity() {
      ConnectivityManager connectivityManager = (ConnectivityManager) 
      context.getSystemService(Context.CONNECTIVITY_SERVICE);
      NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
      return activeNetwork != null;
}