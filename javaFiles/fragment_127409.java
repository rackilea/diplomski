public void onClickTwitt() {
    if (isNetworkAvailable(this)) {
        Twitt twitt = new Twitt(getActivity(), consumer_key, secret_key);
        twitt.shareToTwitter(_Title);
    } else {
        showToast("No Network Connection Available !!!");
    }
}
public boolean isNetworkAvailable(Context context) {
     ConnectivityManager connectivity =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

    if (connectivity == null) {
        return false;
    } else {
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