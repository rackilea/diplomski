private void connectToAP(String ssid, String passkey) {
    WifiManager wifiManager = (WifiManager) context.getSystemService(WIFI_SERVICE);
    Log.i(TAG, "* connectToAP");

    WifiConfiguration wifiConfiguration = new WifiConfiguration();
    List<ScanResult> scanResultList = wifiManager.getScanResults();



    for (ScanResult result : scanResultList) {
        if (result.SSID.equals(ssid)) {

            String securityMode = getScanResultSecurity(result);

            if (securityMode.equalsIgnoreCase("OPEN")) {

                wifiConfiguration.SSID = "\"" + ssid + "\"";
                wifiConfiguration.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
                int res = wifiManager.addNetwork(wifiConfiguration);
                Log.d(TAG, "# add Network returned " + res);

                boolean b = wifiManager.enableNetwork(res, true);
                Log.d(TAG, "# enableNetwork returned " + b);

                wifiManager.setWifiEnabled(true);

            } else if (securityMode.equalsIgnoreCase("WEP")) {

                wifiConfiguration.SSID = "\"" + ssid + "\"";
                wifiConfiguration.wepKeys[0] = "\"" + passkey + "\"";
                wifiConfiguration.wepTxKeyIndex = 0;
                wifiConfiguration.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
                wifiConfiguration.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);
                int res = wifiManager.addNetwork(wifiConfiguration);
                Log.d(TAG, "### 1 ### add Network returned " + res);

                boolean b = wifiManager.enableNetwork(res, true);
                Log.d(TAG, "# enableNetwork returned " + b);

                wifiManager.setWifiEnabled(true);
            }

            wifiConfiguration.SSID = "\"" + ssid + "\"";
            wifiConfiguration.preSharedKey = "\"" + passkey + "\"";
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.status = WifiConfiguration.Status.ENABLED;
            wifiConfiguration.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
            wifiConfiguration.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
            wifiConfiguration.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
            wifiConfiguration.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);
            wifiConfiguration.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);
            wifiConfiguration.allowedProtocols.set(WifiConfiguration.Protocol.RSN);
            wifiConfiguration.allowedProtocols.set(WifiConfiguration.Protocol.WPA);

            int res = wifiManager.addNetwork(wifiConfiguration);
            Log.d(TAG, "### 2 ### add Network returned " + res);

            wifiManager.enableNetwork(res, true);

            boolean changeHappen = wifiManager.saveConfiguration();

            if (res != -1 && changeHappen) {
                Log.d(TAG, "### Change happen");


            } else {
                Log.d(TAG, "*** Change NOT happen");
            }

            wifiManager.setWifiEnabled(true);
        }
    }
}