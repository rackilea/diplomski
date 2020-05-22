You have to check if internet is available. Below code will help in that case. If it is not available you can simple make webview visiblity to gone or do not load anything and show alert dialog for no network 

public static boolean isNetworkAvailable(Context mContext) {

                ConnectivityManager connectivityManager
                        = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();

        }