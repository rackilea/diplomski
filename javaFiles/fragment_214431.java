public final boolean isInternetOn() {

    // get Connectivity Manager object to check connection
    ConnectivityManager connec =
            (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);

    // Check for network connections
    if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
            connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
            connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
            connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {

        // if connected with internet
        Toast.makeText(getActivity(), " Connected ", Toast.LENGTH_LONG).show();

        return true;

    } else if (
            connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                    connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED) {
        Toast.makeText(getActivity(), " Not Connected ", Toast.LENGTH_LONG).show();
        return false;
    }
    return false;
}