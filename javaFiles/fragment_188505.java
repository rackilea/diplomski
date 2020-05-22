class scan extends AsyncTask<Void, Void, ArrayList<ClientScanResult>> { 

protected ArrayList<ClientScanResult> doInBackground(Void... params) {
    wifiApManager = new WifiApManager(context);  // use the variable here
    return wifiApManager.getClientList(false);
}

protected void onPostExecute(ArrayList<ClientScanResult> clients){

tv.setText("WifiApState: " + wifiApManager.getWifiApState() + "\n\n");
tv.append("Clients: \n");
for (ClientScanResult clientScanResult : clients) //showin error in clients
    {
        tv.append("####################\n");
        tv.append("IpAddr: " + clientScanResult.getIpAddr() + "\n");
        tv.append("Device: " + clientScanResult.getDevice() + "\n");
        tv.append("HWAddr: " + clientScanResult.getHWAddr() + "\n");
        tv.append("isReachable: " + clientScanResult.isReachable()+ "\n");
    }
}