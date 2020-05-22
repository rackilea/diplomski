public String connectToXs() {
    try {
        WifiManager wifiManager = (WifiManager) this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        if (!wifiManager.getConnectionInfo().getSSID().equals("\"ssid\"")) {

            WifiConfiguration wc = new WifiConfiguration();
            wc.SSID = "\"ssid\"";

            wc.preSharedKey  = "\"key\"";
            wc.status = WifiConfiguration.Status.ENABLED;
            wc.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
            wc.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
            wc.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
            wc.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);
            wc.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);
            wc.allowedProtocols.set(WifiConfiguration.Protocol.RSN);
            wc.allowedProtocols.set(WifiConfiguration.Protocol.WPA);
            int res = wifiManager.addNetwork(wc);
            Log.d("WifiPreference", "add Network returned " + res );
            final boolean[] b = new boolean[1];
            Thread t = new Thread(() -> {
                b[0] = wifiManager.enableNetwork(res, true);
                wifiManager.setWifiEnabled(true);
                try {
                    Thread.sleep(3000);
                }
                catch (Exception e){
                    Log.d("ERROR",e.toString());
                }
            });
            t.start();
            t.join();
            Log.d("WifiPreference", "enableNetwork returned " + b[0]);

            return wifiManager.getConnectionInfo().toString();
        } else {
            Log.d("WIFI", "already connected");
            return "already connected";
        }
    } catch (Exception ex) {
        Log.d("ERROR", ex.toString());
    }
    return "nougabollen";
}

public String connectToGuest() {
    try {
        WifiManager wifiManager = (WifiManager) this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (!wifiManager.getConnectionInfo().getSSID().equals("\"" + "ssid2" + "\"")) {

            //int networkId = wifiManager.addNetwork(conf);
            int networkId = -2;
            List<WifiConfiguration> configs = wifiManager.getConfiguredNetworks();
            for(WifiConfiguration wc : configs){
                if(wc.SSID.equals("\"SSID2\"")){
                    networkId = wc.networkId;
                }
            }
            int finalNetworkId = networkId;
            wifiManager.disconnect();
            Thread t = new Thread(() -> {
                wifiManager.enableNetwork(finalNetworkId, true);
                try {
                    Thread.sleep(3000);
                }
                catch (Exception e){
                    Log.d("ERROR",e.toString());
                }
            });
            t.start();
            t.join();
            wifiManager.reconnect();
            Log.d("re connecting", wifiManager.getConnectionInfo().getSSID());
            return  "tried networkId: " + networkId + "   " + wifiManager.getConnectionInfo().toString();
        } else {
            Log.d("WIFI", "already connected");
            return "already connected";
        }
    } catch (Exception ex) {
        Log.d("ERROR", ex.toString());
    }
    return "smoutebollen";
}