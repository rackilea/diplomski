public boolean isOnline() {


final ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE); 

final NetworkInfo networkInfo = cm.getActiveNetworkInfo();

int type = networkInfo.getType();

String typeName = networkInfo.getTypeName();

boolean connected = networkInfo.isConnected();

if (connected)
    return true;
else
    return false;

}