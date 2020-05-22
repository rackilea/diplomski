private boolean isNetworkConnected() {
ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
NetworkInfo ni = cm.getActiveNetworkInfo();
if (ni == null) {
// There are no active networks.
AlertDialog.Builder altDialog= new AlertDialog.Builder(this);
altDialog.setMessage("No network connection!");
return false;
} else
return true;
}