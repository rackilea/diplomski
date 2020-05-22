public class ConnectionDetector {

private Context context;

public ConnectionDetector(Context cont){
this.context = cont;
}

public boolean isConnectingToInternet(){
ConnectivityManager connectivity = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
if (connectivity != null)
{
   NetworkInfo[] info = connectivity.getAllNetworkInfo();
   if (info != null) {
   for (int i = 0; i < info.length; i++) {
   if (info[i].getState() == NetworkInfo.State.CONNECTED) {
        return true;
    }
}
}

}
return false;
}
}