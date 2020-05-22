public class MiscUtils{
public static isConnected(Context context){
ConnectivityManager connectivityManager=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo !=null && activeNetworkInfo.isConnected();
}
}