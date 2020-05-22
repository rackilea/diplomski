public class CheckInternet extends AsyncTask<Void, Void, Boolean>{
 private static final String TAG = "CheckInternet";
private Context context;


public CheckInternet(Context context) {
    this.context = context;

}

@Override
protected Boolean doInBackground(Void... voids) {
    Log.d(TAG, "doInBackground: ");
    ConnectivityManager cm =
            (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

    assert cm != null;
    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    boolean isConnected = activeNetwork != null &&
            activeNetwork.isConnected();

    if (isConnected) {
        if ( executeCommand()) return true;
    }
    return false;
}

private boolean executeCommand(){
    System.out.println("executeCommand");
    Runtime runtime = Runtime.getRuntime();
    try
    {
        Process  mIpAddrProcess = runtime.exec("/system/bin/ping -c "+"www.google.com");
        int mExitValue = mIpAddrProcess.waitFor();
        System.out.println(" mExitValue "+mExitValue);
        if(mExitValue==0){
            return true;
        }else{
            return false;
        }
    }
    catch (InterruptedException ignore)
    {
        ignore.printStackTrace();
        System.out.println(" Exception:"+ignore);
    }
    catch (IOException e)
    {
        e.printStackTrace();
        System.out.println(" Exception:"+e);
    }
    return false;
}